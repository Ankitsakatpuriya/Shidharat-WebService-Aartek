package com.hyringspree.serviceImpl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.common.util.JwtUtils;
import com.hyringspree.model.User;
import com.hyringspree.repository.UserRepository;
import com.hyringspree.service.UserService;
import com.nimbusds.jose.JOSEException;

@Service(value = "userDetailsService")
public class UserServiceImpl implements UserService, UserDetails {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;
	/**
	 * findByEmailIdAndPassword
	 * 
	 * @param userData
	 *            the model
	 * @return boolean
	 */

	Map<String, String> mapToken = null;

	public Map<String, String> authenticationRequest(User authenticationRequests)
			throws AuthenticationException, IOException, JOSEException, ParseException {

		String username = authenticationRequests.getEmailId();
		String password = authenticationRequests.getPassword();
		password = new String(java.util.Base64.getDecoder().decode(password));

		String token = "";
		session = request.getSession(true);

		List<User> listOfUser = userRepository.findByEmailIdAndPassword(authenticationRequests);
			session.setAttribute("listSize", listOfUser.size());
			for (User user : listOfUser) {
				if (username != null && username != "" && password != null && password != ""
						&& user.getEmailId() != null && user.getEmailId() != "" && user.getPassword() != null
						&& user.getPassword() != "") {
					String emailId = user.getEmailId();
					String pass = user.getPassword();

					if (username.equals(emailId) && password.equals(pass)) {
						String secret = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("secret.key"),
								Charset.defaultCharset());
						int expirationInMinutes = 30 * 60;

						token = JwtUtils.generateHMACToken(username, secret, expirationInMinutes);
//Authorization Bearer
						session.setAttribute("token", "Bearer " +token);
						mapToken = new HashMap<String, String>();
						mapToken.put("token", "Bearer " + token);
						mapToken.put("emailId", username);
						mapToken.put("password", authenticationRequests.getPassword());
					}
					return mapToken;
				}
			}
		
		mapToken = new HashMap<String, String>();
		mapToken.put("status", "400");
		return mapToken;
	}

	public String getSessionValue() {
		Object objs = session.getAttribute("token");
		if (objs != null) {
			return objs.toString();
		}
		return userRepository.errorJson();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findByEmailIdAndPassword(User userData) {
		return userRepository.findByEmailIdAndPassword(userData);
	}

	public String LogoutUserService() {
		return userRepository.LogoutUserRepository();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean resetPassword(User userData) {
		return userRepository.resetPassword(userData);
	}

}