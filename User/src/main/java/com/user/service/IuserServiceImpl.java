package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repo.IUserRepo;
import com.user.entity.UserDetails;
@Service
public class IuserServiceImpl implements IuserService {
	@Autowired
	IUserRepo iUserRepo;
 
	@Override
	public Integer addUser(UserDetails user) {
		UserDetails addUser=iUserRepo.save(user);
		return addUser.getUserId();
	}

	@Override
	public UserDetails updateUser(UserDetails user, Integer userId) {
		
		UserDetails existingUser=iUserRepo.findById(userId).orElseThrow();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAge(user.getAge());
		existingUser.setEmail(user.getEmail());
		iUserRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(Integer id) {
		iUserRepo.deleteById(id);
		
	}

	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> list=iUserRepo.findAll();
		return list;
	}
	
	@Override
	public Optional<UserDetails> getUser(Integer Id) {
		
		return Optional.ofNullable(iUserRepo.findById(Id).orElseThrow());
	}
}
