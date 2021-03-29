package com.bookpublishinghouse.dao;

import javax.servlet.http.HttpServletRequest;

import com.bookpublishinghouse.model.Book;

public interface BookDao {
	Book validateBookRequest(HttpServletRequest request);
	Boolean add(Book book);
}
