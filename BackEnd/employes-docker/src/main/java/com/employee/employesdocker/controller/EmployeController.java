package com.employee.employesdocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.employesdocker.model.Employe;
import com.employee.employesdocker.service.EmployeService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	@GetMapping
	public ResponseEntity<List<Employe>> findAll() {
		return new ResponseEntity<List<Employe>>(employeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findEmployeById(@PathVariable Long id) {

		if (employeService.findUserById(id) == null) {
			return new ResponseEntity<Integer>(1, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Employe>(employeService.findUserById(id), HttpStatus.OK);
		}

	}

	@PostMapping
	public ResponseEntity<?> addEmploye(@RequestBody Employe employe) {
		return new ResponseEntity<Employe>(employeService.addEmploye(employe), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putEmploye(@RequestBody Employe employe, @PathVariable Long id) {
		Employe character2 = employeService.findUserById(id);
		if (character2 == null) {
			return new ResponseEntity<String>("The Employe not exist", HttpStatus.BAD_REQUEST);
		} else {
			if (character2.getFullName() != null) {
				character2.setFullName(employe.getFullName());
			}

			if (character2.getAppointment() != null) {
				character2.setAppointment(employe.getAppointment());
			}

			if (character2.getUserName() != null) {
				character2.setUserName(employe.getUserName());
			}
			return new ResponseEntity<Employe>(employeService.upDaTeEmploye(character2), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {

		Employe character2 = employeService.findUserById(id);
		if (character2 == null) {
			return new ResponseEntity<String>("Employe not found whit user name: " + character2.getUserName(),
					HttpStatus.BAD_REQUEST);
		}

		employeService.deleteEmploye(id);
		return new ResponseEntity<String>("Employe delete: " + character2.getUserName(), HttpStatus.OK);
	}

}
