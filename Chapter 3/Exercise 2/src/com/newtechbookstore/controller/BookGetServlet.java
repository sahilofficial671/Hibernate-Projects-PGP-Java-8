package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.BookDaoImpl;

@WebServlet("/book/get")
public class BookGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDaoImpl bookDaoImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookGetServlet() {	
    	bookDaoImpl = new BookDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "{}";
		if(request.getParameter("bookId") != null) {
			Integer bookId = Integer.valueOf(request.getParameter("bookId"));
			message = bookDaoImpl.getBookById(bookId).toJson();
		}
		response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
