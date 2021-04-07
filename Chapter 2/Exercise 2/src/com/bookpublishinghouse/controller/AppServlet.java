package com.bookpublishinghouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bookpublishinghouse.model.Author;
import com.bookpublishinghouse.model.Book;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		SessionFactory sessionfactory;
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		sessionfactory = configuration.buildSessionFactory();
//		Session session = sessionfactory.openSession();
//		Transaction t = session.beginTransaction();
//		Book book =  new Book();
//		book.setName("New Book");
//		Author author = new Author();
//		author.setName("Sahil Bhatia");
//		book.setAuthor(author);
//		System.out.println(book);
//		session.persist(book);
//		t.commit();
//		session.close();
		
		response.sendRedirect(request.getContextPath()+"/book/add");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
