package com.itexchange.demo.mybank.dto;

import java.io.Serializable;

import com.itexchange.demo.mybank.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private String surname;

	private String customerId;

	private String email;

	private String mobile;

	private String phone;

	private String password;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public CustomerDto(Customer customer) {
		this.name = customer.getName();
		this.surname = customer.getSurname();
		this.customerId = customer.getCustomerId();
		this.email = customer.getEmail();
		this.mobile = customer.getMobile();
		this.phone = customer.getPhone();
		this.password = customer.getPassword();
	}
}
