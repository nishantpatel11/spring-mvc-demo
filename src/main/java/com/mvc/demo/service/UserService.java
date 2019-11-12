package com.mvc.demo.service;

import com.mvc.demo.model.Login;
import com.mvc.demo.model.User;

public interface UserService {

	  void register(User user);

	  User validateUser(Login login);
}
