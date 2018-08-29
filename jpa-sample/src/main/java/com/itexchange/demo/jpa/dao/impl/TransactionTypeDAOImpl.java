package com.itexchange.demo.jpa.dao.impl;

import javax.persistence.Query;

import com.itexchange.demo.jpa.dao.BaseDAO;
import com.itexchange.demo.jpa.dao.TransactionTypeDAO;
import com.itexchange.demo.jpa.domain.TransactionType;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public class TransactionTypeDAOImpl extends BaseDAO implements TransactionTypeDAO {

	@Override
	public TransactionType findByCustomerId(String transactionTypeId) throws ObjectNotFoundException {
		String strQuery = "SELECT tp FROM "+ getEntityName() +" tp WHERE tp.id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", transactionTypeId);
		TransactionType transactionType = (TransactionType) query.getSingleResult();
		return transactionType;
	}

	@Override
	public TransactionType save(TransactionType transactionType) {
		em.getTransaction().begin();
		em.persist(transactionType);
		em.getTransaction().commit();
		return transactionType;
	}

	@Override
	public TransactionType update(TransactionType transactionType) throws ObjectNotFoundException {
		return null;
	}

	@Override
	public void delete(TransactionType transactionType) throws ObjectNotFoundException {
	}

	@Override
	protected String getEntityName() {
		return TransactionType.class.getName();
	}

}
