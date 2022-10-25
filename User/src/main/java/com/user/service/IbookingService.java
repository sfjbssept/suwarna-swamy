package com.user.service;

import java.util.List;

import com.user.entity.Booking;
import com.user.entity.UserDetails;



public interface IbookingService {
	public Integer newBooking(Booking booking);
	public Booking updateBooking(Booking booking, Integer bookingId);
	public void deleteBooking(Integer id);
	public void cancelBooking(String status, Integer bookingId);
	public List<Booking> getAllBookings();
	
	
	

}
