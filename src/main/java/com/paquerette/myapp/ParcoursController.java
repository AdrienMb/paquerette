package com.paquerette.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.service.ParcoursService;

@Controller
public class ParcoursController {

    private ParcoursService parcoursService;

    @Autowired(required = true)
    @Qualifier(value = "parcoursService")
    public void setJobService(ParcoursService ps) {
        this.parcoursService = ps;
    }

    @RequestMapping(value = "/parcours", method = RequestMethod.GET)
    public String listParcours(Model model) {
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        return "parcours";
    }
}