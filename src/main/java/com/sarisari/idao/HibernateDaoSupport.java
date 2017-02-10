package com.sarisari.idao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author joliveros
 *	mother class for all hibernate Dao
 *  provides session factory that do not need to close after querying
 */
public class HibernateDaoSupport {


		@Autowired
	    private SessionFactory sessionFactory;
		
	    /**
	     * provides session factory that do not need to close after querying
	     * @return Session for crud operations
	     */
	    public Session getSessionFactory() {
	        return sessionFactory.getCurrentSession();
	    }
	    
	    public Query customSelectQuery(String stringQuery){    	
	    	return getSessionFactory().createQuery(stringQuery);
	    }

}

