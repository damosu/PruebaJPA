package com.itexchange.demo.mybank.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.itexchange.demo.mybank.domain.CustomerProduct;
import com.itexchange.demo.mybank.domain.Transaction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionDAOTest {

	@Autowired
	private TestEntityManager testEntityManager;

	private TransactionDAO transactionDAO;

	@Before
	public void before() {
		transactionDAO = new TransactionDAO();
		transactionDAO.setEntityManager(testEntityManager.getEntityManager());
	}

	@Test
	public void testFindByTransactionNumber() {
		Transaction trx = transactionDAO.findByTransactionNumber(452);
		CustomerProduct cp = trx.getCustomerProduct();
		assertThat(trx).isNotNull();
		assertThat(cp).isNotNull();
		assertThat(cp.getProductNumber()).isEqualTo("1000000003");
		assertThat(cp.getCustomer().getCustomerId()).isEqualTo("3012345");
	}
	
	@Test
	public void testGetCustomerTransactions() {
		List<Transaction> transactions = transactionDAO.getCustomerTransactions("3012345");
		assertThat(transactions).isNotEmpty();
		assertThat(transactions.size()).isEqualTo(5);
		assertThat(transactions.get(0).getTransactionNumber()).isEqualTo(452);
	}
}
