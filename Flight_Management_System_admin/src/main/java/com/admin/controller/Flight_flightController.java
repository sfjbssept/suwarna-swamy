package com.admin.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.FlightDetails;
import com.admin.service.IFlightManagement_Flight_Service;

@RestController
public class Flight_flightController {
	@Autowired
	private IFlightManagement_Flight_Service flightService ;

	@PostMapping("/addFlight")
	String addProduct(@RequestBody FlightDetails flight_details) {
		String id= flightService.addFlight(flight_details);
		System.out.println(id);
		return id;
	}
	@GetMapping("/getAllFlights")
	public List<FlightDetails> getAllAirlines() {
		return flightService.getAllFlights();
		
	}
	@GetMapping("/getFlightById/{id}")
	public Optional<FlightDetails>getFlightById(@PathVariable Integer id){
		return flightService.getFlight(id);
		
	}

	@PutMapping("/updatFlight/{id}")
	public ResponseEntity<FlightDetails> updateAirline(@PathVariable("id") Integer id,@RequestBody FlightDetails flight_Details){
		return new ResponseEntity<FlightDetails>(flightService.updateFlightDetails(flight_Details, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<FlightDetails> DeleteProduct(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<FlightDetails> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			flightService.deleteFlight(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/deleteAllFlights")
	public void deleteAllProducts() {
		flightService.deleteAllFlights();
	}

}
