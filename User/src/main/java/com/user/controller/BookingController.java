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

import com.user.entity.Booking;
import com.user.entity.UserDetails;
import com.user.service.IbookingService;

@RestController
public class BookingController {
	@Autowired
	IbookingService iBookingService;
	@PostMapping("/addBooking")
	public Integer addBooking(@RequestBody Booking book) {
		System.out.println(book.getScheduleId());
		Integer id= iBookingService.newBooking(book);
		return id;
	}
	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") Integer id,@RequestBody Booking booking){
		return new ResponseEntity<Booking>(iBookingService.updateBooking(booking, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<Booking> DeleteBooking(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Booking> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			iBookingService.deleteBooking(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@PutMapping("/cancelBooking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id,@RequestBody Booking booking){
		return new ResponseEntity<Booking>(HttpStatus.OK); //check
	}
	@GetMapping("/getAllBookings")
	public List getAllAirlines() {
		return iBookingService.getAllBookings();
		
	}

}
