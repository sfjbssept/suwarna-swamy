package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.UserDetails;

public interface IuserService {

	
	public Integer addUser(UserDetails user);
	public UserDetails updateUser(UserDetails user,Integer userId);
	public void deleteUser(Integer id);
	public List<UserDetails> getAllUsers();
	Optional<UserDetails> getUser(Integer Id);

}
