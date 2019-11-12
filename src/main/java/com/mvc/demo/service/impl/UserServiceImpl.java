package com.mvc.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.demo.dao.UserDao;
import com.mvc.demo.model.Login;
import com.mvc.demo.model.User;
import com.mvc.demo.service.UserService;

public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;

	  public void register(User user) {
	    userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }
}
