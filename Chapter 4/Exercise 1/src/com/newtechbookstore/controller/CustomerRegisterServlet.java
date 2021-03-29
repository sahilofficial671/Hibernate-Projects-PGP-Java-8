package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.newtechbookstore.daoImpl.CustomerDaoImpl;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Customer;
import com.newtechbookstore.util.HibernateUtil;

@WebServlet("/customer/register/submit")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDaoImpl;
       
    public CustomerRegisterServlet() {
		try {
			customerDaoImpl = new CustomerDaoImpl();
		} catch (Exception e) {
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Customer customer = customerDaoImpl.validateAddRequest(request);
			System.out.println(customer.toString());
			
			if(customer != null) {
				customerDaoImpl.add(customer);
				Flash.success(request, "Account Successfully Created.");
			}

			response.sendRedirect("../register");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return ;
		}
	}
}
