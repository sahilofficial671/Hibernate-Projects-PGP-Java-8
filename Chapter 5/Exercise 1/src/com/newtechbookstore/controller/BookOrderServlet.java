package com.newtechbookstore.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newtechbookstore.daoImpl.BookDaoImpl;
import com.newtechbookstore.daoImpl.CustomerDaoImpl;
import com.newtechbookstore.daoImpl.OrderDaoImpl;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Book;
import com.newtechbookstore.model.Customer;
import com.newtechbookstore.model.Order;
import com.newtechbookstore.util.HibernateUtil;

@WebServlet("/book/order/submit")
public class BookOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDaoImpl bookDaoImpl;
	private OrderDaoImpl orderDaoImpl;
	private CustomerDaoImpl customerDaoImpl;
	
    public BookOrderServlet() {
        bookDaoImpl = new BookDaoImpl();
        orderDaoImpl = new OrderDaoImpl();
        customerDaoImpl = new CustomerDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(!customerDaoImpl.checkAuth(request)) {
				response.sendRedirect(request.getContextPath()+"/customer/login");
				return ;
			}
			
			Order order = orderDaoImpl.validateAddOrderRequest(request);
			
			if(order != null && orderDaoImpl.add(order)) {
				Flash.success(request, "Order Successfull.");
			}
			
			response.sendRedirect(request.getContextPath() + "/book/order");
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
