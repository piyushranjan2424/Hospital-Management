package com.spring.data.jpa.entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	@Column(nullable = false, length = 100)
	private String doctorName;
	@Column(length = 100)
	private String specialization;
	@Column(nullable = false, length = 40, unique = true)
	private String doctorEmail;
	@ManyToMany(mappedBy = "doctors")
	private Set<Department> departments = new HashSet<Department>();
}
