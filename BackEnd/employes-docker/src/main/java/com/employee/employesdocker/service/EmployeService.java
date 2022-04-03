package com.employee.employesdocker.service;

import java.util.List;

import com.employee.employesdocker.model.Employe;

public interface EmployeService {
	
	public List<Employe> findAll();
	public Employe addEmploye(Employe employe);
	public void deleteEmploye(Long id);
	public Employe upDaTeEmploye(Employe employe);
	public Employe findUserById(Long id);

}
