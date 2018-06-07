package com.paquerette.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping(value="/")
    public ModelAndView mainPage() {
        return new ModelAndView("login");
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginInForm() {
        return "login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId,@RequestParam String password) {
        User user = UserService.loginUser(userId,password);
        if ( user == null ) {
        	return "login";
        }
        return "redirect:/home";
	}
	
	
}
