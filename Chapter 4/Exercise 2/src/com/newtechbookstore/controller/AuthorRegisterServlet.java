package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.newtechbookstore.daoImpl.AuthorDaoImpl;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Author;
import com.newtechbookstore.util.HibernateUtil;

@WebServlet("/author/add/submit")
public class AuthorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthorDaoImpl authorDaoImpl;
       
    public AuthorRegisterServlet() {
		try {
			authorDaoImpl = new AuthorDaoImpl();
		} catch (Exception e) {
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Author customer = authorDaoImpl.validateAddRequest(request);
			
			if(customer != null) {
				authorDaoImpl.add(customer);
				Flash.success(request, "Author Added.");
			}

			response.sendRedirect("../register");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return ;
		}
	}
}
