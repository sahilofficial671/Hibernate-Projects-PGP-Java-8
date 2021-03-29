package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.BookDaoImpl;
import com.newtechbookstore.daoImpl.CustomerDaoImpl;

@WebServlet("/book/order")
public class BookOrderViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDaoImpl bookDaoImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookOrderViewServlet() {
    	bookDaoImpl = new BookDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!new CustomerDaoImpl().checkAuth(request)) {
			response.sendRedirect(request.getContextPath()+"/customer/login");
			return ;
		}
		request.setAttribute("books", bookDaoImpl.getBooks());
		request.getRequestDispatcher("/pages/book/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
