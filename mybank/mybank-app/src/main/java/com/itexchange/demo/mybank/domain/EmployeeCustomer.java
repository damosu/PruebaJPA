package com.itexchange.demo.mybank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "employee_customer")
public class EmployeeCustomer extends SpecialCustomer {
	
	@Column(name = "employee_id")
	private String employeeId;
	
	private String surname;
	
	private String mobile;
}
