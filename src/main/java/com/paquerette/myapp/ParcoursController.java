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

    // For add and update Job both
    @RequestMapping(value = "/parcours/add", method = RequestMethod.POST)
    public String addParcours(@ModelAttribute("parcours") Parcours p) {

        if (p.getId() == 0) {
            // new Job, add it
            this.parcoursService.addParcours(p);
        } else {
            // existing Job, call update
            this.parcoursService.updateParcours(p);
        }

        return "redirect:/parcours";

    }

    @RequestMapping("/parcours/remove/{id}")
    public String removeParcours(@PathVariable("id") int id) {
        this.parcoursService.removeParcours(id);
        return "redirect:/parcours";
    }

    @RequestMapping("/parcours/edit/{id}")
    public String editParcours(@PathVariable("id") int id, Model model) {
        model.addAttribute("parcours", this.parcoursService.getParcoursById(id));
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        return "parcours";
    }
}