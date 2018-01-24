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
@Table(name = "company_customer")
public class CompanyCustomer extends SpecialCustomer {

	@Column(name = "company_id")
	private String companyId;

	private String phone;
}
