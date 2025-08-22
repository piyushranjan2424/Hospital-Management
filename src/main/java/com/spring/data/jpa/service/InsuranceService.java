package com.spring.data.jpa.service;

import org.springframework.stereotype.Service;

import com.spring.data.jpa.entites.Insurance;
import com.spring.data.jpa.entites.Patient;
import com.spring.data.jpa.repo.InsuranceRepo;
import com.spring.data.jpa.repo.PatientRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {
	private InsuranceRepo insuranceRepo;
	private PatientRepo patientRepo;

	public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
		Patient patient = patientRepo.findById(patientId)
				.orElseThrow(() -> new EntityNotFoundException("Patient not found with id : " + patientId));
		patient.setInsurance(insurance);
		insurance.setPatient(patient);
		return patient;
	}
}
