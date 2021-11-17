package com.slalom.example;

import com.slalom.config.ManualConfig;
import com.slalom.example.domain.entity.User;

public class Main {
	public static void main(String[] args) {
		// Setup
		var config = new ManualConfig();
		var createUser = config.createUser();
		var findUser = config.findUser();
		var loginUser = config.loginUser();
		var user = User.builder()
			.email("joe.santiago@gmail.com")
			.password("mypassword")
			.lastName("Joe")
			.firstName("Santi")
			.build();

		// Create a user
		var actualCreateUser = createUser.create(user);
		System.out.println("User created with id " + actualCreateUser.getId());

		// Find a user by id
		var actualFindUser = findUser.findById(actualCreateUser.getId());
		System.out.println("Found user with id " + actualFindUser.get().getId());

		// List all users
		var users = findUser.findAllUsers();
		System.out.println("List all users: " + users);

		// Login
		loginUser.login("joe.santiago@gmail.com", "mypassword");
		System.out.println("Allowed to login with email 'joe.santiago@gmail.com' and password  'mypassword'");
	}
}
