package com.colorvision.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;
import com.colorvision.uis.model.User;
import com.colorvision.uis.service.UserService;
import com.colorvision.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();

		String choice = JOptionPane.showInputDialog("Enter choice: save|update|delete|list|get");

		switch (choice) {
		case "save":
			User user = getUser();
			int saved = userService.saveUserInfo(user);
			if (saved >= 1) {
				JOptionPane.showMessageDialog(null, "User info is saved successfully in db.");
			} else {
				JOptionPane.showMessageDialog(null, "Error in db.");
			}
			break;
		case "update":
			User updatedUser = getUser();
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
			updatedUser.setId(id);
			int updated = userService.updateUserInfo(updatedUser);
			if (updated >= 1) {
				JOptionPane.showMessageDialog(null, "User info is updated successfully in db.");
			} else {
				JOptionPane.showMessageDialog(null, "Error in db.");
			}
			break;

		case "delete":

			id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));

			int deleted = userService.deleteUserInfo(id);
			if (deleted >= 1) {
				JOptionPane.showMessageDialog(null, "User info is deleted successfully in db.");
			} else {
				JOptionPane.showMessageDialog(null, "Error in db.");
			}
			break;

		case "list":
			List<User> userList = userService.getAllUserInfo();
			for (User u : userList) {
				System.out.println("User id is :" + u.getId());
				System.out.println("User name is :" + u.getUsername());
				System.out.println("User password is :" + u.getPassword());
				System.out.println("User mobile no is :" + u.getMobileNo());
				System.out.println("User salary is :" + u.getSalary());
				System.out.println("User active? :" + u.isActive());
				System.out.println("====================================");
				
			}
			
		case "get":
			id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
             User u = userService.getUserById(id);
         	System.out.println("User id is :" + u.getId());
			System.out.println("User name is :" + u.getUsername());
			System.out.println("User password is :" + u.getPassword());
			System.out.println("User mobile no is :" + u.getMobileNo());
			System.out.println("User salary is :" + u.getSalary());
			System.out.println("User active? :" + u.isActive());
			System.out.println("====================================");
			break;

		default:
			JOptionPane.showInputDialog(null, "wrong choice.");
			break;
		}
	}

	public static User getUser() {
		User user = new User();
		String username = JOptionPane.showInputDialog("Enter username: ");
		String password = JOptionPane.showInputDialog("Enter password: ");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no: "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user active ? "));
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		return user;
	}

}

//in real time there are service, controller, model & dao