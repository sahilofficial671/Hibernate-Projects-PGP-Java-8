package com.newtechbookstore.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newtechbookstore.dao.CustomerDao;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Address;
import com.newtechbookstore.model.Customer;
import com.newtechbookstore.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao{
	
	public Customer validateAddRequest(HttpServletRequest request) {
		// Customer Fields
		String firstName, lastName, gender, dob, email, phone, userName, password;
		firstName = lastName = gender = email = dob = password = userName = phone = "";
		
		// Customer Address Fields
		String line_1, line_2, city, state, country;
		line_1 = line_2 = city = state = country = "";
		Integer pincode = null;
		
		if(request.getParameter("firstName") != null) {
			firstName = request.getParameter("firstName");
		}
		
		if(request.getParameter("lastName") != null) {
			lastName = request.getParameter("lastName");
		}
		
		if(request.getParameter("dob") != null) {
			dob = request.getParameter("dob");
		}
		
		if(request.getParameter("gender") != null) {
			gender = request.getParameter("gender");
		}
		
		if(request.getParameter("email") != null) {
			email = request.getParameter("email");
		}
		
		if(request.getParameter("userName") != null) {
			userName = request.getParameter("userName");
		}
		
		if(request.getParameter("password") != null) {
			password = request.getParameter("password");
		}
		
		if(request.getParameter("phone") != null) {
			phone = request.getParameter("phone");
		}
		
		if(request.getParameter("line_1") != null) {
			line_1 = request.getParameter("line_1");
		}
		
		if(request.getParameter("line_2") != null) {
			line_2 = request.getParameter("line_2");
		}
		
		if(request.getParameter("pincode") != null) {
			pincode = Integer.valueOf(request.getParameter("pincode"));
		}
		
		if(request.getParameter("city") != null) {
			city = request.getParameter("city");
		}
		
		if(request.getParameter("state") != null) {
			state = request.getParameter("state");
		}
		
		if(request.getParameter("country") != null) {
			country = request.getParameter("country");
		}
		
		Boolean details_validation = (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || gender.isEmpty() 
								     || email.isEmpty() || userName.isEmpty() || password.isEmpty());
		
		Boolean address_validation = (line_1.isEmpty() || pincode == null || city.isEmpty() || state.isEmpty() || country.isEmpty());
		
		// Validate
		if(details_validation && address_validation) {
			Flash.error(request, "Fill all the mandatory fields (*).");
			return null;
		}
		
		// Address
		Address address = new Address();
		address.setLine_1(line_1);
		address.setLine_2(line_2);
		address.setPincode(pincode);
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);

		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("YYYY-mm-dd").parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Customer with Address
		Customer customer =  new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setGender(gender);
		customer.setDob(dateOfBirth);
		customer.setEmail(email);
		customer.setUserName(userName);
		customer.setPhone(phone);
		customer.setPassword(password);
		customer.setAddress(address);

		System.out.println(customer);
		return customer;
	}
	
	@Override
	public Boolean add(Customer customer) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			session.close();
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean validateLogin(HttpServletRequest request) {
		String userName, password;
		userName = password = "";
		
		if(request.getParameter("userName") != null) {
			userName = request.getParameter("userName");
		}
		
		if(request.getParameter("password") != null) {
			password = request.getParameter("password");
		}
		
		// Validate
		if(userName.isEmpty() || password.isEmpty()) {
			Flash.error(request, Flash.error_fill_all_fields);
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean checkAuth(HttpServletRequest request) {
		if(request.getSession().getAttribute("logged") != null && (boolean) request.getSession().getAttribute("logged")) {
			return true;
		}
		Flash.error(request, "Please log in first.");
		request.getSession().setAttribute("redirect_to", request.getRequestURI());
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean authenticate(HttpServletRequest request) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			List<Customer> customers = session.createQuery("from Customer where userName = :userName And password = :password")
										      .setParameter("userName", userName)
										      .setParameter("password", password)
										      .list();
			
			// If No Customer found
			if(customers.isEmpty()) {
				Flash.error(request, "Username & Password don't match.");
				return false;
			}
			
			Customer customer = new Customer();
			Integer count = 0;
			
			for(Customer cust : customers) {
				count++;
				if(count == 1 && cust.getUserName().equals(userName) && cust.getPassword().equals(password)) {
					customer.setId(cust.getId());
					customer.setFirstName(cust.getFirstName());
					customer.setLastName(cust.getLastName());
					customer.setGender(cust.getGender());
					customer.setAddress(cust.getAddress());
					customer.setDob(cust.getDob());
					customer.setEmail(cust.getEmail());
					customer.setUserName(cust.getUserName());
					customer.setPhone(cust.getPhone());
				}
			}
			
			tx.commit();
			session.close();
			
			// Only one customer found
			if(count == 1) {
				request.getSession().setAttribute("logged", true);
				request.getSession().setAttribute("customer", customer);
				return true;
			}
			
			Flash.error(request, "Something went wrong. Please contact administrator.");
			return false;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
}
