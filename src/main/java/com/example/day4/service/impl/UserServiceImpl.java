package com.example.day4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.UserModel;
import com.example.day4.repository.UserRepository;
import com.example.day4.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
   private UserRepository rep;
	@Override
	public boolean addUser(UserModel user) {
		// TODO Auto-generated method stub
		boolean userExists=rep.existsByEmail(user.getEmail());
		if(!userExists) {
			rep.save(user);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<UserModel> getUser() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

}
