package com.paquerette.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.UserService;
import com.paquerette.myapp.service.UserServiceImpl;

@Controller
public class LoginController {
	
	private UserService UserService;
	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setModuleService(UserService us) {
		this.UserService = us;
	}
	
	@RequestMapping(value="/")
    public ModelAndView mainPage() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user",new User());
        return model;
    }
	
	@RequestMapping(value = "/login")
	public String showLoginInForm(Model model) {
		model.addAttribute("user",new User());
        return "login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@ModelAttribute("user")User user, BindingResult result,  ModelMap model,HttpServletRequest request,Model model2) {
        User usercheck = UserService.loginUser((user.getName()),user.getPassword());
        if ( usercheck == null ) {
        	return "login";
        }
        request.getSession().setAttribute("user",usercheck); 
        model2.addAttribute("isAdmin", UserServiceImpl.isAdmin(usercheck));
        return "home";
	}
	
	
}
