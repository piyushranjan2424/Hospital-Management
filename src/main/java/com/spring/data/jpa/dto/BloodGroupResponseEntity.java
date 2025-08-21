package com.spring.data.jpa.dto;

import com.spring.data.jpa.entites.BloodGroupType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupResponseEntity {
	private BloodGroupType bloodGroupType;
	private Long Count;

}
