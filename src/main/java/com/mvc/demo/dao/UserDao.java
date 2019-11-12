package com.mvc.demo.dao;

import com.mvc.demo.model.Login;
import com.mvc.demo.model.User;

public interface UserDao {

	void register(User user);
	User validateUser(Login login);
}
