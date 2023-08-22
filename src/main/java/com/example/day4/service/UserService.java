package com.example.day4.service;

import java.util.List;

import com.example.day4.model.UserModel;

public interface UserService {
	public boolean addUser(UserModel user);
	
	public List<UserModel> getUser();
	

}
