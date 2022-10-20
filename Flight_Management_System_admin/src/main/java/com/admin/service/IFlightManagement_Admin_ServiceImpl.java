package com.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.Repo.IAirlineRepo;
import com.admin.entity.Airline;
@Service
public class IFlightManagement_Admin_ServiceImpl implements IFlightManagement_Admin_Service{
	@Autowired
	IAirlineRepo iAirlineRepo;

	@Override
	public Integer addAirline(Airline airline) {
		
		Airline addAirline=iAirlineRepo.save(airline);
		return addAirline.getId();
	}

	@Override
	public List<Airline> getAllAirlines() {
		List<Airline> list=iAirlineRepo.findAll();
		return list;
	
	}

	@Override
	public Optional<Airline> getAirline(Integer Id) {
		
		return Optional.ofNullable(iAirlineRepo.findById(Id).orElseThrow());
	}

	@Override
	public Airline updateAirline(Airline airline, Integer id) {
		Airline existingAirline=iAirlineRepo.findById(id).orElseThrow();
		existingAirline.setName(airline.getName());
		existingAirline.setUpdatedOn(airline.getUpdatedOn());
		existingAirline.setCreatedOn(airline.getCreatedOn());
		iAirlineRepo.save(existingAirline);
		
		return existingAirline;
	}

	@Override
	public void deleteAirline(Integer id) {
		iAirlineRepo.deleteById(id);
		
	}

	@Override
	public void deleteAllAirlines() {
		iAirlineRepo.deleteAll();
	}

}
