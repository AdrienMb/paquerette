package com.paquerette.myapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	 private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	 
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	        this.sessionFactory = sf;
	    }
	 
	 @Override
	    public User getUserByName(String userId) {
	        Session session = this.sessionFactory.getCurrentSession();
	        User u = (User) session.load(User.class, new String());   
	        logger.info("User loaded successfully, User details=" + u);
	        return u;
	    }
	 	 
}