package com.employee.employesdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employesdocker.model.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Long> {

}
