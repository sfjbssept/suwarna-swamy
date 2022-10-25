package com.user.service;

import java.util.List;

import com.user.entity.PassengerDetails;

public interface IpassengerService {
	public Integer addPassenger(PassengerDetails passenger);
	public PassengerDetails updatePassenger(PassengerDetails passenger,Integer passengerId);
	public void deletePassenger(Integer id);
	public List<PassengerDetails> getAllPassengers();

}
