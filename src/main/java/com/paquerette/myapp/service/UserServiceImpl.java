package com.paquerette.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.UserDAO;
import com.paquerette.myapp.model.User;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
	
    @Override
    @Transactional
    public User getUserByName(String name) {
        return this.userDAO.getUserByName(name);
    }
    
    public User loginUser(String name, String password) {
    	User user = this.getUserByName(name);
    	System.out.println(user.getPassword()+user.getName()+user.getId());
    	if (user != null && user.getPassword().equals(password)) {
    		return user;
    	}
    	return null;
    }

 }