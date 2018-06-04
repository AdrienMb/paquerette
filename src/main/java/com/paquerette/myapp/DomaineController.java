package com.paquerette.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.service.DomaineService;

@Controller
public class DomaineController {

    private DomaineService domaineService;

    @Autowired(required = true)
    @Qualifier(value = "domaineService")
    public void setJobService(DomaineService ps) {
        this.domaineService = ps;
    }

    @RequestMapping(value = "/domaines", method = RequestMethod.GET)
    public String listDomaines(Model model) {
        model.addAttribute("domaine", new Domaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        return "jobs";
    }
}