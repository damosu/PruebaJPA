package com.itexchange.demo.jpa.dao;

import com.itexchange.demo.jpa.domain.Transaction;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public interface TransactionDAO {

	Transaction findByTransactionId(String transactionId) throws ObjectNotFoundException;
	
	Transaction save(Transaction transaction);
	
	Transaction update(Transaction transaction) throws ObjectNotFoundException;
	
	void delete(Transaction transaction) throws ObjectNotFoundException;
}
