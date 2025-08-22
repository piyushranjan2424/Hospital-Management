package com.spring.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.jpa.entites.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}
