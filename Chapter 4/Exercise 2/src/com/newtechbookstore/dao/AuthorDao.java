package com.newtechbookstore.dao;

import javax.servlet.http.HttpServletRequest;

import com.newtechbookstore.model.Author;

public interface AuthorDao {
	
    /**
     * If validation passed return Customer otherwise null
     * 
     * @param HttpServletRequest request
     * @return Customer|null
     */
	Author validateAddRequest(HttpServletRequest request);
	
    /**
     * Add Customer to database.
     * 
     * @param Author customer
     * @return Boolean
     */
	Boolean add(Author author);
}
