package com.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.entity.PassengerDetails;

public interface IPassengerRepo extends JpaRepository<PassengerDetails,Integer> {

}
