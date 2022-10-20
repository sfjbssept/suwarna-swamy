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


import com.admin.entity.Airline;
import com.admin.service.IFlightManagement_Admin_Service;


@RestController
public class Flight_Admin_Controller {
	@Autowired
	IFlightManagement_Admin_Service iFlightManagement_Admin_Service;
	@PostMapping("/addAirline")
	Integer addProduct(@RequestBody Airline airline) {
		Integer id= iFlightManagement_Admin_Service.addAirline(airline);
		System.out.println(id);
		return id;
	}
	@GetMapping("/getAllAirlines")
	public List getAllAirlines() {
		return iFlightManagement_Admin_Service.getAllAirlines();
		
	}
	@GetMapping("/getAirlineById/{id}")
	public Optional<Airline> getAirlineById(@PathVariable Integer id){
		return iFlightManagement_Admin_Service.getAirline(id);
		
	}

	@PutMapping("/updateAirline/{id}")
	public ResponseEntity<Airline> updateAirline(@PathVariable("id") Integer id,@RequestBody Airline airline){
		return new ResponseEntity<Airline>(iFlightManagement_Admin_Service.updateAirline(airline, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAirline/{id}")
	public ResponseEntity<Airline> DeleteProduct(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Airline> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			iFlightManagement_Admin_Service.deleteAirline(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/deleteAllAirlines")
	public void deleteAllProducts() {
		iFlightManagement_Admin_Service.deleteAllAirlines();
	}

}
