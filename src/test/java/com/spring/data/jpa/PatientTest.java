package com.spring.data.jpa;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.data.jpa.dto.BloodGroupResponseEntity;
import com.spring.data.jpa.entites.BloodGroupType;
import com.spring.data.jpa.entites.Patient;
import com.spring.data.jpa.repo.PatientRepo;
import com.spring.data.jpa.service.PatientService;

@SpringBootTest
public class PatientTest {
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private PatientService patientService;

	@Test
	public void testPatientRepo() {
		List<Patient> patList = patientRepo.findAll();
		System.out.println("Patient List : ");
		patList.forEach(System.out::println);
	}

	@Test
	public void testTranscationMethod() {
		Patient patient = patientService.getPatientById(3L);
		System.out.println("Patient : " + patient);
		System.out.println("//////////////////////////////////");
		Patient patient2 = patientRepo.findByPatientName("Anita Singh");
		System.out.println("Patient : " + patient2);
		System.out.println("//////////////////////////////////");
		List<Patient> patient3 = patientRepo.findByBirthDateOrPatientEmail(LocalDate.of(1998, 12, 24),
				"Monika@gmail.com");
		patient3.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<Patient> patient4 = patientRepo.findByBirthDateBetween(LocalDate.of(1995, 8, 21),
				LocalDate.of(1998, 12, 24));
		patient4.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<Patient> patient5 = patientRepo.findByPatientNameContaining("it");
		patient5.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<Patient> patient6 = patientRepo.findByPatientNameContainingOrderByPatientIdDesc("it");
		patient6.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<Patient> patient7 = patientRepo.findByBloodGroup(BloodGroupType.A_NEGATIVE);
		patient7.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<Patient> patient8 = patientRepo.findByBornAfterDate(LocalDate.of(1990, 6, 12));
		patient8.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		List<BloodGroupResponseEntity> objects = patientRepo.CountEachBloodGroup();
		objects.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		Page<Patient> patientPage = patientRepo.findAllPatients(PageRequest.of(0, 5, Sort.by("patientName").descending()));
		patientPage.forEach(System.out::println);
		System.out.println("//////////////////////////////////");
		int rowsUpdated = patientRepo.updatePatientNameWithPatientId("Piyush Ranjan", 1L);
		System.out.println("Rows updated: " + rowsUpdated);

	}
}
