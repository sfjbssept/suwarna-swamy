package com.user.controller;

import java.util.List;

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


import com.user.entity.PassengerDetails;
import com.user.service.IpassengerService;

@RestController
public class PassengerController {
	@Autowired
	IpassengerService iPassengerService;
	@PostMapping("/addPassenger")
	Integer addProduct(@RequestBody PassengerDetails passenger) {
		Integer id= iPassengerService.addPassenger(passenger);
		System.out.println(id);
		return id;
	}
	@GetMapping("/getAllPassengers")
	public List getAllAirlines() {
		return iPassengerService.getAllPassengers();
		
	}
	@PutMapping("/updatePassenger/{id}")
	public ResponseEntity<PassengerDetails> updatePassenger(@PathVariable("id") Integer id,@RequestBody PassengerDetails passenger){
		return new ResponseEntity<PassengerDetails>(iPassengerService.updatePassenger(passenger, id),HttpStatus.OK);
	}
	@DeleteMapping("/deletePassenger/{id}")
	public ResponseEntity<PassengerDetails> DeleteProduct(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<PassengerDetails> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			iPassengerService.deletePassenger(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	

}
