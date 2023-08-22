package com.example.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.UserModel;
import com.example.day4.repository.UserRepository;
import com.example.day4.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService ser;
	@Autowired 
	UserRepository usrRepo;
	@GetMapping("/getUser")
	public ResponseEntity<List<UserModel>> getUser(){
		return ResponseEntity.status(200).body(ser.getUser());
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserModel user){
		boolean dataSaved = ser.addUser(user);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully!");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong!");
			
		}
	}
//	multiple datas
	@PostMapping("/multiple")
	public ResponseEntity<String> saveMultiple(@RequestBody List<UserModel> u){
		
		usrRepo.saveAllAndFlush(u);
		return ResponseEntity.ok(" saved multiple data ");
	}

}
