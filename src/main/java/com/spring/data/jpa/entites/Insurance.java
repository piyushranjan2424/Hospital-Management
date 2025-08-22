package com.spring.data.jpa.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "insurance", uniqueConstraints = {
		@UniqueConstraint(name = "unique_policy_Number", columnNames = { "policyNumber" }) })
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long insuranceId;
	@Column(nullable = false, length = 50)
	private String provider;
	@Column(nullable = false, length = 100)
	private String policyNumber;
	@Column(nullable = false)
	private LocalDate validUntil;
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@OneToOne(mappedBy = "insurance")
	private Patient patient;

}
