package com.newtechbookstore.model;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer customerId;
	private String line_1, line_2;
	private Integer picode;
	private String city, state, country;
	private Customer customer;
	public Address() {}

	public Address(Integer customerId, String line_1, String line_2, Integer picode, String city, String state,
			String country, Customer customer) {
		super();
		this.customerId = customerId;
		this.line_1 = line_1;
		this.line_2 = line_2;
		this.picode = picode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLine_1() {
		return line_1;
	}

	public void setLine_1(String line_1) {
		this.line_1 = line_1;
	}

	public String getLine_2() {
		return line_2;
	}

	public void setLine_2(String line_2) {
		this.line_2 = line_2;
	}

	public Integer getPincode() {
		return picode;
	}

	public void setPincode(Integer picode) {
		this.picode = picode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [customerId=" + customerId + ", line_1=" + line_1 + ", line_2=" + line_2 + ", picode=" + picode + ", city="
				+ city + ", state=" + state + ", country=" + country + "]";
	}
	
}
