package com.newtechbookstore.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newtechbookstore.dao.AuthorDao;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Address;
import com.newtechbookstore.model.Author;
import com.newtechbookstore.util.HibernateUtil;

public class AuthorDaoImpl implements AuthorDao{
	
	public Author validateAddRequest(HttpServletRequest request) {
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
								     || email.isEmpty());
		
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
		Author author =  new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setGender(gender);
		author.setDob(dateOfBirth);
		author.setEmail(email);
		author.setPhone(phone);
		author.setAddress(address);
		return author;
	}
	
	@Override
	public Boolean add(Author author) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(author);
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
