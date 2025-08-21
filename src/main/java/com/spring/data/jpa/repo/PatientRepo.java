package com.spring.data.jpa.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.dto.BloodGroupResponseEntity;
import com.spring.data.jpa.entites.BloodGroupType;
import com.spring.data.jpa.entites.Patient;

import jakarta.transaction.Transactional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

	Patient findByPatientName(String name);

	List<Patient> findByBirthDateOrPatientEmail(LocalDate birthDate, String patientEmail);

	List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

	List<Patient> findByPatientNameContaining(String query);

	List<Patient> findByPatientNameContainingOrderByPatientIdDesc(String query);

	@Query("SELECT p FROM Patient p WHERE p.bloodGroup=:bloodGroup")
	List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodgroup);

	@Query("SELECT p FROM Patient p WHERE p.birthDate>:birthDate")
	List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

	@Query("SELECT new com.spring.data.jpa.dto.BloodGroupResponseEntity( p.bloodGroup, count(p.patientId)) FROM Patient p GROUP BY p.bloodGroup")
	List<BloodGroupResponseEntity> CountEachBloodGroup();

	@Query("SELECT p FROM Patient p")
	Page<Patient> findAllPatients(Pageable pageable);

	@Transactional
	@Modifying
	@Query("UPDATE Patient p SET p.patientName=:patientName WHERE p.patientId=:patientId")
	int updatePatientNameWithPatientId(@Param("patientName") String patientName, @Param("patientId") Long patientId);
}
