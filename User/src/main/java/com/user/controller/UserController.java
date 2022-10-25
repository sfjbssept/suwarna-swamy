package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.user.entity.UserDetails;
import com.user.service.IuserServiceImpl;

@RestController
public class UserController {
	@Autowired
	IuserServiceImpl iUserServiceimpl;
	@PostMapping("/addUser")
	Integer addUser(@RequestBody UserDetails user) {
		Integer id=iUserServiceimpl.addUser(user);
		return id;
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDetails> updateUser(@PathVariable("id") Integer userId,@RequestBody UserDetails user){
		return new ResponseEntity<UserDetails>(iUserServiceimpl.updateUser(user, userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<UserDetails>deleteUsers(@PathVariable("id")Integer id) {
		System.out.println(id);
		ResponseEntity<UserDetails> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			iUserServiceimpl.deleteUser(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@GetMapping("/getAllUsers")
	public List getAllUsers() {
		return iUserServiceimpl.getAllUsers();
}
}
