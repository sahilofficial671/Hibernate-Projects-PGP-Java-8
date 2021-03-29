package com.newtechbookstore.dao;

import javax.servlet.http.HttpServletRequest;

import com.newtechbookstore.model.Customer;

public interface CustomerDao {
	
    /**
     * Validate Add Request
     * 
     * @param HttpServletRequest request
     * @return Customer|null
     */
	Customer validateAddRequest(HttpServletRequest request);
	
    /**
     * Add Customer to database.
     * 
     * @param Customer customer
     * @return Boolean
     */
	Boolean add(Customer customer);
	
    /**
     * Validate Login Request
     * 
     * @param HttpServletRequest request
     * @return Boolean
     */
	Boolean validateLogin(HttpServletRequest request);
	
    /**
     * Check if Auth Exists in Request Session
     * 
     * @param HttpServletRequest request
     * @return Boolean
     */
	Boolean checkAuth(HttpServletRequest request);
	
    /**
     * Attemp to Authenticate & If passed bind customer to session
     * 
     * @param HttpServletRequest request
     * @return Boolean
     */
	Boolean authenticate(HttpServletRequest request);
}
