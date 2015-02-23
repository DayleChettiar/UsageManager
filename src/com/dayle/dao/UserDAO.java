package com.dayle.dao;

import java.util.List;

import com.dayle.model.User;

public interface UserDAO {
	void addUser(User user);
	 
	void updateUser(User user);
	 
	void deleteUser(User user);
	 
	List<User> getAllUsers();
	 
	User getUserById(long userId);
	 
	List<User> getUsers(long userId, String usgType);
}
