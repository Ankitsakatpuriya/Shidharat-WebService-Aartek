package com.hyringspree.repository;

import com.hyringspree.model.User;

public interface ForgetRepository {

	public String findById(User userEmail);
	
}
