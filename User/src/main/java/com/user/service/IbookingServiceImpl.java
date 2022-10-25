package com.user.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repo.IBookingRepo;
import com.user.entity.Booking;
import com.user.entity.UserDetails;
@Service
class IbookingServiceImpl implements IbookingService{
	@Autowired
	IBookingRepo bookingRepo;
	public Integer newBooking(Booking booking) {
		Booking newBooking=bookingRepo.save(booking);
		return newBooking.getId();
	}

	@Override
	public Booking updateBooking(Booking booking, Integer bookingId) {
		Booking existingBooking=bookingRepo.findById(bookingId).orElseThrow();
		existingBooking.setStatus(booking.getStatus());
		existingBooking.setUser(booking.getUser());
		existingBooking.setScheduleId(booking.getScheduleId());
		bookingRepo.save(existingBooking);
		return existingBooking;
	}

	@Override
	public void deleteBooking(Integer id) {
		
		bookingRepo.deleteById(id);
	}

	@Override
	public void cancelBooking(String status,Integer bookingId) {
		Booking book=bookingRepo.findById(bookingId).orElseThrow();
		book.setStatus(status);
		bookingRepo.save(book);	
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> list=bookingRepo.findAll();
		return list;
	}

}
