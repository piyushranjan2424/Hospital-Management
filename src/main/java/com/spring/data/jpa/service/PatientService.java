package com.spring.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.entites.Patient;
import com.spring.data.jpa.repo.PatientRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	@Autowired
	private PatientRepo patientRepo;
//	@Autowired
//	private final EntityManager entityManager;

	@Transactional
	public Patient getPatientById(Long id) {
		Patient p1 = patientRepo.findById(id).orElseThrow();
		Patient p2 = patientRepo.findById(id).orElseThrow();
		System.out.println(p1 == p2);
		p1.setPatientName("Yoyo Deo");
		p1.setPatientEmail("Yoyo.deo@gmail.com");
		
		return p1;
	}
}
