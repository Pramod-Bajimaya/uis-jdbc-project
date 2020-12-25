package com.colorvision.uis.dao;
import java.util.List;

import com.colorvision.uis.model.User;
public interface UserDao {
	
	int saveUserInfo(User user);
	
	int updateUserInfo(User user);
	
	int deleteUserInfo(int id);
	
	List<User> getAllUserInfo();
	
	User getUserById(int id);
	
}
