package com.itexchange.demo.jpa.dao.impl;

import javax.persistence.Query;

import com.itexchange.demo.jpa.dao.BaseDAO;
import com.itexchange.demo.jpa.dao.TransactionDAO;
import com.itexchange.demo.jpa.domain.Transaction;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public class TransactionDAOImpl extends BaseDAO implements TransactionDAO{

	@Override
	public Transaction findByTransactionId(String transactionId) throws ObjectNotFoundException {
		String strQuery = "SELECT t FROM "+ getEntityName() +" t WHERE t.id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", transactionId);
		Transaction transaction = (Transaction) query.getSingleResult();
		return transaction;
	}

	@Override
	public Transaction save(Transaction transaction) {
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		return transaction;
	}

	@Override
	public Transaction update(Transaction transaction) throws ObjectNotFoundException {
		return null;
	}

	@Override
	public void delete(Transaction transaction) throws ObjectNotFoundException {
	}

	@Override
	protected String getEntityName() {
		return Transaction.class.getName();
	}

}
