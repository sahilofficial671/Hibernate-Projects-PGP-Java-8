package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.helpers.Flash;

/**
 * Servlet implementation class LoginViewController
 */
@WebServlet("/customer/logout")
public class CustomerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogoutServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("logged") != null) {
			
			// Empty Session Variables
			request.getSession().setAttribute("logged", null);
			request.getSession().setAttribute("customer", null);
			request.getSession().invalidate();
			
			// Set Session Message
			Flash.success(request, "Successfully logged out.");
			
			// Redirect to home page.
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("pages/error/404.jsp");
		rd.forward(request, response);
	}
}
