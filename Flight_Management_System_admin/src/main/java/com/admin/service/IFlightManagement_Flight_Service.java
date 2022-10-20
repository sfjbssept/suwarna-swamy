package com.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.admin.entity.FlightDetails;


public interface IFlightManagement_Flight_Service {
	public String addFlight(FlightDetails flightDetails);
	public List<FlightDetails> getAllFlights();
	Optional<FlightDetails> getFlight(Integer Id);
	FlightDetails updateFlightDetails(FlightDetails flightDetails,Integer id);
	public void deleteFlight(Integer id);
	public void deleteAllFlights();
}