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
    public User getUserByName(String userId) {
        return this.userDAO.getUserByName(userId);
    }
    
    public User loginUser(String userId, String password) {
    	User user = this.getUserByName(userId);
    	if (user != null && user.getPassword().equals(password)) {
    		return user;
    	}
    	return null;
    }
}
    