package com.mvc.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.demo.model.Login;
import com.mvc.demo.model.User;
import com.mvc.demo.service.UserService;

@Controller
public class LoginController {
  
	static final String LOGIN = "login";
	
	@Autowired
  UserService userService;
  
  @GetMapping("/login")
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView(LOGIN);
    mav.addObject(LOGIN, new Login());
    return mav;
  }
  @PostMapping("/loginProcess")
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (null != user) {
    mav = new ModelAndView("welcome");
    mav.addObject("firstname", user.getFirstname());
    } else {
    mav = new ModelAndView(LOGIN);
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
}
