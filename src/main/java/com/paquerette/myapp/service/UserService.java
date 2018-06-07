package com.paquerette.myapp.service;

import com.paquerette.myapp.model.User;

public interface UserService {
	public User getUserByName(String userId);
	public User loginUser(String userId, String password);
}
