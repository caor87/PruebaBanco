package com.employee.employesdocker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Table(name = "employe", uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
@Data
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullName;
	private String appointment;
	private String userName;

	public void setBoss(Employe employe) {
		this.fullName = employe.getFullName();
		this.appointment = employe.getAppointment();
	}
}
