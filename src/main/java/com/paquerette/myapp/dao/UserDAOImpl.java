package com.paquerette.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	 private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	 
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	        this.sessionFactory = sf;
	    }
	 
     @SuppressWarnings("unchecked")
//     	public List<User> listUser(){
//    	 	Session session = this.sessionFactory.getCurrentSession();
//    	 	List<User> UserList = session.createQuery("from user").list();
//    	 	for (User u : UserList) {
//    	        logger.info("User List::" + u);
//    	    }
//    	    return UserList;
//     }
	 
     @Override
     @Transactional
     public User getUserByName(String name) {
    			List<User> users = new ArrayList<User>();

    			        users = sessionFactory.getCurrentSession()
    			            .createQuery("from User where name=?")
    			            .setParameter(0,name)
    			            .list();

    			        if (users.size() > 0) {
    			            return users.get(0);
    			        } else {
    			            return null;
    			        }
     }
     

}

    		
