package com.newtechbookstore.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
}
