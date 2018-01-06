package com.itexchange.demo.jpa;

import com.itexchange.demo.jpa.dao.CustomerDAO;
import com.itexchange.demo.jpa.dao.impl.CustomerDAOImpl;
import com.itexchange.demo.jpa.domain.Customer;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = customerDAO.findByCustomerId("1012345");
		System.out.println("Customer found: " + customer.getName());
		} catch (ObjectNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
