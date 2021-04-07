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
@WebServlet("/customer/login/submit")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDaoImpl; 
       
    public CustomerLoginServlet() {
    	customerDaoImpl = new CustomerDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Validate & Autheticate
			if(customerDaoImpl.validateLogin(request) && customerDaoImpl.authenticate(request)) {
				Flash.success(request, "You have logged in.");
				
				if(request.getSession().getAttribute("redirect_to") != null) {
					String redirect_to = (String)request.getSession().getAttribute("redirect_to");
					request.getSession().setAttribute("redirect_to", null);
					response.sendRedirect(redirect_to);
					return ;
				}
				
				response.sendRedirect(request.getContextPath()+"/customer/profile");
				return ;
			}
			
			response.sendRedirect(request.getContextPath()+"/customer/login");
			return ;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return;
		}
	}
}
