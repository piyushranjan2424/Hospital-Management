package com.spring.data.jpa;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.entites.Insurance;
import com.spring.data.jpa.entites.Patient;
import com.spring.data.jpa.service.InsuranceService;

@SpringBootTest
public class InsuranceTest {
	private InsuranceService insuranceService;

	@Test
	public void testInsurance() {
		Insurance insurance = Insurance.builder().policyNumber("SC-PLCY-005").provider("SecureCare Group")
				.validUntil(LocalDate.of(2027, 03, 20)).build();
		Patient patient = insuranceService.assignInsuranceToPatient(insurance, 55L);
		System.out.println(patient);
	}

}
