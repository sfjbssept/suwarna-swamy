package com.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserDetails;

public interface IUserRepo extends JpaRepository<UserDetails,Integer> {

}
