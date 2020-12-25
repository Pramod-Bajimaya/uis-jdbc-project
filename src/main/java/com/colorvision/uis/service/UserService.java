package com.colorvision.uis.service;

import java.util.List;

import com.colorvision.uis.model.User;

public interface UserService {

	int saveUserInfo(User user);

	int updateUserInfo(User user);

	int deleteUserInfo(int id);
	
	List<User> getAllUserInfo();
	
	User getUserById(int id);
}
