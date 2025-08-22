package com.spring.data.jpa.entites;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;
	@Column(nullable = false)
	private LocalDateTime appointmentTime;
	@Column(length = 100)
	private String reason;
	@ManyToOne
	@JoinColumn(name = "appointment_patient_id", nullable = false)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "appointment_doctor_id", nullable = false)
	private Doctor doctor;
}
