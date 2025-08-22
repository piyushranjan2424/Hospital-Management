package com.spring.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.jpa.entites.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
