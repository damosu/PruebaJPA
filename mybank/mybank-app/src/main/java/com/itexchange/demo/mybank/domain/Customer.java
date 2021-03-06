package com.itexchange.demo.mybank.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.itexchange.demo.mybank.domain.dto.CustomerNames;
import com.itexchange.demo.mybank.validation.GroupCustomerContactInfo;
import com.itexchange.demo.mybank.validation.GroupCustomerNames;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@NamedNativeQuery(
	name = "find_cust_name_and_surname_dto",
	query = "SELECT name, surname FROM customer",
	resultSetMapping = "name_and_surname_dto"
)
@SqlResultSetMapping(
	name = "name_and_surname_dto",
	classes = @ConstructorResult(
		targetClass = CustomerNames.class,
		columns = {
			@ColumnResult(name = "name"),
			@ColumnResult(name = "surname")
		}
	)
)
@GroupSequence({ Customer.class, GroupCustomerNames.class, GroupCustomerContactInfo.class })
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotNull(groups = GroupCustomerNames.class)
	private String name;

	@NotNull(groups = GroupCustomerNames.class)
	private String surname;

	@NotNull
	@Column(name = "customer_id")
	private String customerId;

	@NotNull(groups = GroupCustomerContactInfo.class)
	@Pattern(regexp = "^(.+)@(.+)$")
	private String email;

	@NotNull(groups = GroupCustomerContactInfo.class)
	private String mobile;

	@NotNull(groups = GroupCustomerContactInfo.class)
	private String phone;

	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
}