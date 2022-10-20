package com.admin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.admin.entity.FlightDetails;

public interface IFlightRepo extends JpaRepository<FlightDetails,Integer>
{

}
