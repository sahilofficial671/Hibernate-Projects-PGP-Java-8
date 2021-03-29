package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.BookDaoImpl;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Book;

@WebServlet("/book/add/submit")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDaoImpl bookDaoImpl;
	
    public BookAddServlet() {
        bookDaoImpl = new BookDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Book book = bookDaoImpl.validateBookRequest(request);
			if(book != null) {
				System.out.println(book.toString());
				if(bookDaoImpl.add(book)) {
					Flash.success(request, "Book Addded Successfully.");
				}
			}
			response.sendRedirect(request.getContextPath());
			return ;
		} catch (Exception e) {
			e.printStackTrace();
			String message = "Error From: "+ this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"(), Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			Flash.error(request, message);
			response.sendRedirect(request.getContextPath());
			return ;
		}

	}
}
