package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.User;
import com.hyringspree.service.ForgetService;
import com.hyringspree.util.IConstant;

@RestController
public class ForgetController {
	@Autowired
	private ForgetService forgetService;
	/**
	 * forgetPassword
	 * @param String emailId
	 * @return void
	 * */
	@PostMapping(path = IConstant.FORGET_PASSWORD) 
	public boolean forgetPassword(@RequestBody String emailId) {
		Gson gson = new Gson(); 
		User userEmail = gson.fromJson(emailId, User.class);
		return forgetService.findByEmailId(userEmail);

	}
}  
  