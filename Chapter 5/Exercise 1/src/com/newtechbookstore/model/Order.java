package com.newtechbookstore.model;

import java.util.Date;

public class Order {
	private Integer id, bookId, customerId, quantity;
	private String shippingAddress;
	private Date orderedAt;
	private Book book;
	private Customer customer;
	
	public Order() {}

	public Order(Integer id, Integer bookId, Integer customerId, Integer quantity, String shippingAddress,
			Date orderedAt, Book book, Customer customer) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.shippingAddress = shippingAddress;
		this.orderedAt = orderedAt;
		this.book = book;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", bookId=" + bookId + ", customerId=" + customerId + ", quantity=" + quantity
				+ ", shippingAddress=" + shippingAddress + ", orderedAt=" + orderedAt + ", book=" + book + ", customer="
				+ customer + "]";
	}

}