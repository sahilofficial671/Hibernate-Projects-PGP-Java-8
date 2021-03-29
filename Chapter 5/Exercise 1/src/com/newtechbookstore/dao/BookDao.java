package com.newtechbookstore.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.newtechbookstore.model.Book;

public interface BookDao {
	Book validateBookRequest(HttpServletRequest request);
	Boolean add(Book book);
	Book getBookById(Integer bookId);
	List<Book> getBooks();
	Boolean decreaseBookQuantityBy(Book book, Integer quantity);
}
