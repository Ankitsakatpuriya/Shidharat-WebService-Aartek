package com.hyringspree.filter;

import static com.hyringspree.security.JwtUtils.assertNotExpired;
import static com.hyringspree.security.JwtUtils.assertValidSignature;
import static com.hyringspree.security.JwtUtils.getUsername;
import static com.hyringspree.security.JwtUtils.parse;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hyringspree.model.User;
import com.hyringspree.security.JwtUtils;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

	private RequestMatcher requestMatcher;
	private String secretKey;

	public JwtTokenAuthenticationFilter(String path, String secretKey) {
		this.requestMatcher = new AntPathRequestMatcher(path);
		this.secretKey = secretKey;
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		if (!requiresAuthentication(request)) {
			/*
			 * if the URL requested doesn't match the URL handled by the filter,
			 * then we chain to the next filters.
			 */
			chain.doFilter(request, response);
			return;
		}

		if (header == null) {
			/*
			 * If there's not authentication information, then we chain to the
			 * next filters. The SecurityContext will be analyzed by the chained
			 * filter that will throw AuthenticationExceptions if necessary
			 */
			chain.doFilter(request, response);
			return;
		}

		try {
			/*
			 * The token is extracted from the header. It's then checked
			 * (signature and expiration) An Authentication is then created and
			 * registered in the SecurityContext. The SecurityContext will be
			 * analyzed by chained filters that will throw Exceptions if
			 * necessary (like if authorizations are incorrect).
			 */
			SignedJWT jwt = extractAndDecodeJwt(request);
			checkAuthenticationAndValidity(jwt);
			Authentication auth = buildAuthenticationFromJwt(jwt, request);
			SecurityContextHolder.getContext().setAuthentication(auth);

			chain.doFilter(request, response);

		} catch (ParseException ex) {
			throw new AccountExpiredException("Token is not valid anymore");
		} catch (JOSEException ex) {
			throw new MalformedJwtException("Token is malformed1");
		} catch (Exception ex) {
			throw new MalformedJwtException("Token is malformed2");
		}

		/* SecurityContext is then cleared since we are stateless. */
		SecurityContextHolder.clearContext();
	}

	private boolean requiresAuthentication(HttpServletRequest request) {
		return requestMatcher.matches(request);
	}

	private SignedJWT extractAndDecodeJwt(HttpServletRequest request) throws ParseException {
		String authHeader = request.getHeader(AUTHORIZATION);
		String token = authHeader.substring("Bearer ".length());
		return parse(token);
	}

	private void checkAuthenticationAndValidity(SignedJWT jwt) throws ParseException, JOSEException {
		assertNotExpired(jwt);
		assertValidSignature(jwt, secretKey);
	}

	private Authentication buildAuthenticationFromJwt(SignedJWT jwt, HttpServletRequest request) throws ParseException {

		String username = getUsername(jwt);
		Collection<? extends GrantedAuthority> authorities = JwtUtils.getRoles(jwt);
		// Date creationDate = getIssueTime(jwt);
		String password = JwtUtils.getPassword(jwt);
		User userDetails = new User(username, password, authorities);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				authorities);
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return authentication;
	}

}