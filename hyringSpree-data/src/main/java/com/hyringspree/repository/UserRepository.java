package com.hyringspree.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hyringspree.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	public List<User> findByEmailIdAndPassword(User userData);
	
	public String errorJson();
	
	public User findByUsername(String userName);
	
	public String LogoutUserRepository();

	public Boolean resetPassword(User userData);
	
}