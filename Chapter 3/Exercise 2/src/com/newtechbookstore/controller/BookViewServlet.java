package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.BookDaoImpl;

@WebServlet("/books")
public class BookViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDaoImpl bookDaoImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookViewServlet() {
    	bookDaoImpl = new BookDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books", bookDaoImpl.getBooks());
		request.getRequestDispatcher("/pages/book/view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
