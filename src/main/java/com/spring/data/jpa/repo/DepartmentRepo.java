package com.spring.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.jpa.entites.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
