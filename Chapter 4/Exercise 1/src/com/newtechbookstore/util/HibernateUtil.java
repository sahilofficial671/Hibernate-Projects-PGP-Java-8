package com.newtechbookstore.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
    public static SessionFactory getSessionFactory() {
    	if(sessionFactory != null ) return sessionFactory;
    	return createSessionFactory();
    }
    
    public static SessionFactory createSessionFactory() {
    	try {
    		sessionFactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	}catch(Exception e) {
    		System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
    	}
    	return sessionFactory;
    }
    
    public static void shutdown() {
        getSessionFactory().close();
    }

}
