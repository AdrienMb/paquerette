package com.paquerette.myapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.service.PrerequisService;
import com.paquerette.myapp.service.DomaineService;
import com.paquerette.myapp.service.ModuleService;

@Controller
public class PrerequisController {

	private PrerequisService prerequisService;
    private DomaineService domaineService;

//    @Autowired(required = true)
//    @Qualifier(value = "moduleService")
//    public void setModuleService(ModuleService ms) {
//        this.ModuleService = ms;
//    }
    
//    @Autowired(required = true)
//    @Qualifier(value = "domaineService")
//    public void setDomaineService(DomaineService ds) {
//        this.domaineService = ds;
//    }

//    @RequestMapping(value = "/modules", method = RequestMethod.GET)
//    public String listModules(Model model) {
//        model.addAttribute("module", new Module());
//        model.addAttribute("listDomaines", this.domaineService.listDomaines());
//        model.addAttribute("listModules", this.ModuleService.listModules());
//        return "module";
//    }

    // For add and update Module both
//    @RequestMapping(value = "/module/add", method = RequestMethod.POST)
//    public String addModule(@ModelAttribute("Module") Module m) {
//
//        if (m.getId() == 0) {
//            // new Module, add it
//            this.ModuleService.addModule(m);
//        } else {
//            // existing Module, call update
//            this.ModuleService.updateModule(m);
//        }
//
//        return "redirect:/Modules";
//
//    }
    @Autowired(required = true)
    @Qualifier("prerequisService")
    public void setPrerequisService(PrerequisService ms) {
        this.prerequisService = ms;
    }
    
	@RequestMapping(value = "/prerequis", method = RequestMethod.GET)
	public String getAllPrequis(Model model) {
   	model.addAttribute("listPrerequis", this.prerequisService.getAllPrerequis());
        return "prerequis";
    }
	
}