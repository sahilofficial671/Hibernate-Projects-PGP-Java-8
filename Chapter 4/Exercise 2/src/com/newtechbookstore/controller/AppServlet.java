package com.newtechbookstore.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.newtechbookstore.model.Address;
import com.newtechbookstore.model.Author;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		SessionFactory sessionfactory;
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		sessionfactory = configuration.buildSessionFactory();
//		Session session = sessionfactory.openSession();
//
//		Transaction t = session.beginTransaction();
//		Author author = new Author();
//		author.setFirstName("Ravi Malik");
//		author.setEmail("ravi@gmail.com");
//
//		Address address1 = new Address();
//		address1.setLine_1("G-21,Lohia nagar");
//		author.setAddress(address1);
//		address1.setAuthor(author);
//		session.persist(author);
//		t.commit();
//		session.close();
//		System.out.println("success");
////		
		response.sendRedirect("author/add");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
