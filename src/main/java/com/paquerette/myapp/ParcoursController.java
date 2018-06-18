package com.paquerette.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.ParcoursService;
import com.paquerette.myapp.service.UserServiceImpl;

@Controller
public class ParcoursController {

    private ParcoursService parcoursService;

    @Autowired(required = true)
    @Qualifier(value = "parcoursService")
    public void setJobService(ParcoursService ps) {
        this.parcoursService = ps;
    }

    @RequestMapping(value = "/parcours", method = RequestMethod.GET)
    public String listParcours(Model model,HttpServletRequest request) {
    	if (request.getSession().getAttribute("user")==null) return "redirect:/login";
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "parcours";
    }
}