package com.paquerette.myapp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.service.PrerequisService;
import com.paquerette.myapp.service.DomaineService;
import com.paquerette.myapp.service.ModuleService;

@Controller
public class PrerequisController {

	private PrerequisService prerequisService;
    private DomaineService domaineService;

    @Autowired(required = true)
    @Qualifier("prerequisService")
    public void setPrerequisService(PrerequisService ms) {
        this.prerequisService = ms;
    }
    
	@RequestMapping(value = "/prerequis", method = RequestMethod.GET)
	public String getAllPrequis(Model model) {
	model.addAttribute("prerequis", new Prerequis());
   	model.addAttribute("listPrerequis", this.prerequisService.getAllPrerequis());
        return "prerequis";
    }
	@RequestMapping(value = "/prerequis/findParcoursByprerequis", method = RequestMethod.POST)
	public String findParcoursByprerequis(@RequestParam("prerequis") List<Prerequis> p ,Model model) {
		System.out.println(p.size());
        return "prerequis";
    }
	
}