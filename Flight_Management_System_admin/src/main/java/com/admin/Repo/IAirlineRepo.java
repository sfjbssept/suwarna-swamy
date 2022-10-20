package com.admin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.Airline;

public interface IAirlineRepo extends JpaRepository<Airline,Integer> {

}
