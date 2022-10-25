package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repo.IPassengerRepo;
import com.user.entity.PassengerDetails;
@Service
public class IpassengerServiceImpl implements IpassengerService {
@Autowired
IPassengerRepo passengerRepo;
	@Override
	public Integer addPassenger(PassengerDetails passenger) {
		PassengerDetails newPassenger=passengerRepo.save(passenger);
		return newPassenger.getPassengerId();
	}

	@Override
	public PassengerDetails updatePassenger(PassengerDetails passenger, Integer passengerId) {
		PassengerDetails existingPassenger=passengerRepo.findById(passengerId).orElseThrow();
		existingPassenger.setName(passenger.getName());
		existingPassenger.setGender(passenger.getGender());
		existingPassenger.setMeals(passenger.getMeals());
		existingPassenger.setSeatNo(passenger.getSeatNo());
		existingPassenger.setBookingPassenger(passenger.getBookingPassenger());
		passengerRepo.save(existingPassenger);
		return existingPassenger;
		}

	@Override
	public void deletePassenger(Integer id) {
		passengerRepo.deleteById(id);
		
	}

	@Override
	public List<PassengerDetails> getAllPassengers() {
    List <PassengerDetails> list=passengerRepo.findAll();
    return list;
	}

}
