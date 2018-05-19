package com.paquerette.myapp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.service.ModuleService;
import com.paquerette.myapp.service.DomaineService;

@Controller
public class ModuleController {

    private ModuleService ModuleService;
    private DomaineService domaineService;

    @Autowired(required = true)
    @Qualifier(value = "moduleService")
    public void setModuleService(ModuleService ms) {
        this.ModuleService = ms;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "domaineService")
    public void setDomaineService(DomaineService ds) {
        this.domaineService = ds;
    }

    @RequestMapping(value = "/modules", method = RequestMethod.GET)
    public String listModules(Model model) {
        model.addAttribute("module", new Module());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("listModules", this.ModuleService.listModules());
        return "module";
    }

    // For add and update Module both
    @RequestMapping(value = "/module/add", method = RequestMethod.POST)
    public String addModule(@ModelAttribute("Module") Module m) {

        if (m.getId() == 0) {
            // new Module, add it
            this.ModuleService.addModule(m);
        } else {
            // existing Module, call update
            this.ModuleService.updateModule(m);
        }

        return "redirect:/Modules";

    }

    @RequestMapping("/module/remove/{id}")
    public String removeModule(@PathVariable("id") int id) {
        this.ModuleService.removeModule(id);
        return "redirect:/Modules";
    }

    @RequestMapping("module/edit/{id}")
    public String editModule(@PathVariable("id") int id, Model model) {
        model.addAttribute("Module", this.ModuleService.getModuleById(id));
        model.addAttribute("listModules", this.ModuleService.listModules());
        return "module";
    }
    
    @RequestMapping(value = "/module/findParcoursByModuleId", method = RequestMethod.POST)
    public String findParcoursByModuleId(@RequestParam("modulesId") List<Integer> m, Model model) {
    	System.out.println(m);
    	ArrayList<Parcours> parcours=new ArrayList<Parcours>();
    	for(Integer mod : m) {
    		System.out.println(this.ModuleService.findParcoursByModuleId(mod));
    		parcours.addAll(this.ModuleService.findParcoursByModuleId(mod));
    	}
    	Set<Parcours> hs = new HashSet<Parcours>();
    	hs.addAll(parcours);
    	for(Parcours parcUnique : hs) {
        	System.out.println(Collections.frequency(parcours, hs));
    	}
		model.addAttribute("listParcours", parcours);
        return "parcours";
    }

}