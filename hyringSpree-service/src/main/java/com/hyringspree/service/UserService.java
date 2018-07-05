package com.hyringspree.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.AuthenticationException;

import com.hyringspree.model.User;
import com.nimbusds.jose.JOSEException;

public interface UserService {
	public List<User> findByEmailIdAndPassword(User user);

	public Map<String, String> authenticationRequest(User authenticationRequest) throws AuthenticationException, IOException, JOSEException, ParseException;
	
	public String LogoutUserService();
	
	public String getSessionValue();
	
	public Boolean resetPassword(User userData);
}
 