package com.employee.employesdocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employesdocker.model.Employe;
import com.employee.employesdocker.repository.EmployeRepo;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepo employeRepo;

	@Override
	public List<Employe> findAll() {
		return employeRepo.findAll();
	}

	@Override
	public Employe addEmploye(Employe employe) {
		return employeRepo.save(employe);
	}

	@Override
	public void deleteEmploye(Long id) {
		employeRepo.deleteById(id);		
	}

	@Override
	public Employe upDaTeEmploye(Employe employe) {
		return employeRepo.save(employe);
	}

	@Override
	public Employe findUserById(Long id) {
		return employeRepo.getById(id);
	}

}
