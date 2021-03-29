package com.bookpublishinghouse.model;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name, edition, category, publisher;
	private Integer publishingYear, price, quantity;
	private Author author;
	
	public Book() {
	
	}
	public Book(Integer id, String name, String edition, String category, String publisher,
			Integer publishingYear, Integer price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.category = category;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.price = price;
		this.quantity = quantity;
	}
	public Book(String name, Integer authorId, String edition, String category, String publisher,
			Integer publishingYear, Integer price, Integer quantity) {
		super();
		this.name = name;
		this.edition = edition;
		this.category = category;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.price = price;
		this.quantity = quantity;
	}
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

	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", edition=" + edition + ", category=" + category + ", publisher="
				+ publisher + ", publishingYear=" + publishingYear + ", price=" + price
				+ ", quantity=" + quantity + ", author=" + author + "]";
	}
	
}
