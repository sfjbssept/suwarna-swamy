package com.admin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.Schedule;

public interface IScheduleRepo extends JpaRepository<Schedule,Integer> {

}
