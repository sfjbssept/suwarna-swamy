package com.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.Repo.IFlightRepo;
import com.admin.entity.FlightDetails;

@Service
public class IFlightManagement_Flight_ServiceImpl implements IFlightManagement_Flight_Service {
	@Autowired
	IFlightRepo iFlightRepo;

	@Override
	public String addFlight(FlightDetails flightDetails) {
		FlightDetails addFlight=iFlightRepo.save(flightDetails);
		return addFlight.getFlightnumber();
	}

	@Override
	public List<FlightDetails> getAllFlights() {
		List<FlightDetails> list=iFlightRepo.findAll();
		return list;
	}

	@Override
	public Optional<FlightDetails> getFlight(Integer Id) {
		return Optional.ofNullable(iFlightRepo.findById(Id).orElseThrow());
		
	}

	@Override
	public FlightDetails updateFlightDetails(FlightDetails flightDetails, Integer id) {
		FlightDetails existingFlight=iFlightRepo.findById(id).orElseThrow();
		existingFlight.setAirLine(flightDetails.getAirLine());
		existingFlight.setUpdatedOn(flightDetails.getUpdatedOn());
		existingFlight.setCreatedOn(flightDetails.getCreatedOn());
		existingFlight.setCostPerTicket(flightDetails.getCostPerTicket());
		existingFlight.setNoOfBusinessClassSeats(flightDetails.getNoOfBusinessClassSeats());
		existingFlight.setNoOfEconomyClassSeats(flightDetails.getNoOfEconomyClassSeats());
		existingFlight.setNoOfRows(flightDetails.getNoOfRows());
		iFlightRepo.save(existingFlight);
		
		return existingFlight;
		
	}

	@Override
	public void deleteFlight(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllFlights() {
		// TODO Auto-generated method stub
		
	}

}
