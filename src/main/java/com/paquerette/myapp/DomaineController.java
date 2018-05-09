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

    // For add and update Job both
    @RequestMapping(value = "/domaines/add", method = RequestMethod.POST)
    public String addDomaine(@ModelAttribute("domaine") Domaine p) {

        if (p.getId() == 0) {
            // new Job, add it
            this.domaineService.addDomaine(p);
        } else {
            // existing Job, call update
            this.domaineService.updateDomaine(p);
        }

        return "redirect:/domaine";

    }

    @RequestMapping("/domaine/remove/{id}")
    public String removeDomaine(@PathVariable("id") int id) {
        this.domaineService.removeDomaine(id);
        return "redirect:/domaine";
    }

    @RequestMapping("/domaine/edit/{id}")
    public String editDomaine(@PathVariable("id") int id, Model model) {
        model.addAttribute("domaine", this.domaineService.getDomaineById(id));
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        return "domaine";
    }
}