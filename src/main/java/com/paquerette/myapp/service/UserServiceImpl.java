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
    	if (user != null && user.getPassword().equals(password)) {
    		return user;
    	}
    	return null;
    }

    public static boolean isAdmin(User user) {
    	if (user==null) return false;
    	if (user.getRole()==null) return false;
    	return user.getRole().equals("admin");
    } 	
 }