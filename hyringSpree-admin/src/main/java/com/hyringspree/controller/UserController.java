package com.hyringspree.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.EducationInfo;
import com.hyringspree.model.User;
import com.hyringspree.service.UserService;
import com.hyringspree.util.IConstant;
import com.nimbusds.jose.JOSEException;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * user
	 * 
	 * @param user
	 *            the model
	 * @return String
	 */
	/*@PostMapping(path = IConstant.LOGIN_USER)
	public List<User> userLogin(@RequestBody String user) {
		System.out.println("hiiiiii...."+user);
		Gson gson = new Gson();
		User userData = gson.fromJson(user, User.class);	
		return userService.findByEmailIdAndPassword(userData);
	}*/
	
	@PostMapping(path = IConstant.LOGIN_USER)
	public Map<String, String> authenticationRequest(@RequestBody String user) throws AuthenticationException, IOException, JOSEException, ParseException{
		Gson gson = new Gson();
		User userData = gson.fromJson(user, User.class);
		
		return userService.authenticationRequest(userData);
	}
	
	@GetMapping(path = IConstant.LOGOUT_USER)
	public String LogoutUser(){
		return userService.LogoutUserService();
		
	}
	
	@PostMapping(path = IConstant.RESET_PASSWORD)
	public String resetPassword(@RequestBody String user){
		System.out.println("resetPassword......... "+user);
		
		Gson gson = new Gson();
		User userData = gson.fromJson(user, User.class);
		
		 Boolean status = userService.resetPassword(userData);
		 if (status) {
				return IConstant.SUCCESS;
			} else {
				return IConstant.ERROR;
			}
		
	}
	


}
