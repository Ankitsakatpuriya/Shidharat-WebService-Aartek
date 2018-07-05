package com.hyringspree.filter;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * SecurityAuthenticationEntryPoint is called by ExceptionTranslationFilter to
 * handle all AuthenticationException. These exceptions are thrown when
 * authentication failed : wrong login/password, authentication unavailable,
 * invalid token authentication expired, etc.
 *
 * For problems related to access (roles), see RestAccessDeniedHandler.
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// @Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
		wrapper.setStatus(SC_UNAUTHORIZED);
		wrapper.setContentType(APPLICATION_JSON_VALUE);
		wrapper.getWriter().flush();
	}
}
