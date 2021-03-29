package com.newtechbookstore.dao;

import javax.servlet.http.HttpServletRequest;

import com.newtechbookstore.model.Customer;

public interface CustomerDao {
	
    /**
     * If validation passed return Customer otherwise null
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
}
