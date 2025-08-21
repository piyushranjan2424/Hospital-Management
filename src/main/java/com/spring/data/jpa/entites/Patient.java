package com.spring.data.jpa.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "patient", uniqueConstraints = {
		@UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = { "patientName",
				"birthDate" }) }, indexes = { @Index(name = "idx_patient_birth_date", columnList = "birthDate") })
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	@Column(nullable = false, length = 40)
	private String patientName;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(unique = true, nullable = false)
	private String patientEmail;
	private String gender;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@Enumerated(EnumType.STRING)
	private BloodGroupType bloodGroup;
}
