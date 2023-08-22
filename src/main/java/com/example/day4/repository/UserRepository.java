package com.example.day4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	boolean existsByEmail(String email);
	

}
