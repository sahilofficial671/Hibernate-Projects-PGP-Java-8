package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.CustomerDaoImpl;
import com.newtechbookstore.helpers.Flash;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/customer/profile")
public class CustomerProfileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDaoImpl; 
       
    public CustomerProfileViewServlet() {
    	customerDaoImpl = new CustomerDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!new CustomerDaoImpl().checkAuth(request)) {
			response.sendRedirect(request.getContextPath()+"/customer/login");
			return ;
		}		
		
		request.getRequestDispatcher("/pages/customer/profile.jsp").forward(request, response);
	}
}
