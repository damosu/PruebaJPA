package com.itexchange.demo.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;
	
	@Column(name = "customer_product_id")
	@NotNull
	private Integer customerProductId;
	
	@Column(name = "channel_id")
	@NotNull
	private Integer channelId;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "transaction_number")
	private Integer transactionNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerProductId() {
		return customerProductId;
	}

	public void setCustomerProductId(Integer customerProductId) {
		this.customerProductId = customerProductId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
}
