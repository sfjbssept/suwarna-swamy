package com.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Booking;


public interface IBookingRepo extends JpaRepository<Booking,Integer> {

}
