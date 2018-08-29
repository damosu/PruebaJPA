package com.itexchange.demo.jpa.dao;

import com.itexchange.demo.jpa.domain.TransactionType;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public interface TransactionTypeDAO {

	TransactionType findByCustomerId(String transactionTypeId) throws ObjectNotFoundException;
	
	TransactionType save(TransactionType transactionType);
	
	TransactionType update(TransactionType transactionType) throws ObjectNotFoundException;
	
	void delete(TransactionType transactionType) throws ObjectNotFoundException;
}
