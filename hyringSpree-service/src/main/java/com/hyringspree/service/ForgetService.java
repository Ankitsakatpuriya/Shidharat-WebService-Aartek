package com.hyringspree.service;

import com.hyringspree.model.User;

public interface ForgetService {
	boolean findByEmailId(User userEmail);
}
