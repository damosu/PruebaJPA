package com.itexchange.demo.mybank.dao;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.itexchange.demo.mybank.domain.Customer;
import com.itexchange.demo.mybank.dto.CustomerDto;
import com.itexchange.demo.mybank.exception.ObjectNotFoundException;

@Component
public class CustomerDAO extends BaseDAO {

	@Transactional
	public Customer save(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}
	
	public Customer findByCustomerId(String customerId) throws ObjectNotFoundException {
		String strQuery = "SELECT c FROM Customer c WHERE c.customerId = :customerId";

		try {
			Customer customer = (Customer) entityManager.createQuery(strQuery).setParameter("customerId", customerId)
					.getSingleResult();
			return customer;
		} catch (NoResultException e) {
			throw new ObjectNotFoundException("Customer not found with id: " + customerId);
		}
	}

	@Transactional
	public boolean delete(String customerId) throws ObjectNotFoundException {
		Customer customer = findByCustomerId(customerId);
		entityManager.remove(customer);
		return true;
	}

	@Transactional
	public CustomerDto update(CustomerDto customerInfo) throws ObjectNotFoundException {
		Customer customer = findByCustomerId(customerInfo.getCustomerId());
		customer.setEmail(customerInfo.getEmail());
		customer.setMobile(customerInfo.getMobile());
		customer.setPhone(customerInfo.getPhone());
		customer.setPassword(customerInfo.getPassword());
		entityManager.merge(customer);
		return customerInfo;
	}
}
