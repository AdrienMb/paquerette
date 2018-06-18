package com.paquerette.myapp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.ModuleService;
import com.paquerette.myapp.service.UserServiceImpl;


@Controller
public class ModuleController {

	private ModuleService ModuleService;


	@Autowired(required = true)
	@Qualifier(value = "moduleService")
	public void setModuleService(ModuleService ms) {
		this.ModuleService = ms;
	}

	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public String listModules(Model model,HttpServletRequest request ) {
		if (request.getSession().getAttribute("user")==null) return "redirect:/login";
		model.addAttribute("module", new Module());
		model.addAttribute("listModules", this.ModuleService.listModules());
		model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
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
	public String editModule(@PathVariable("id") int id, Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("user")==null) return "redirect:/login";
		model.addAttribute("Module", this.ModuleService.getModuleById(id));
		model.addAttribute("listModules", this.ModuleService.listModules());
		model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
		return "module";
	}

	@RequestMapping(value = "/module/findParcoursByModuleId", method = RequestMethod.POST)
	public String findParcoursByModuleId(@RequestParam("modulesId") List<Integer> m, Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("user")==null) return "redirect:/login";
		List<Parcours> parcours=new ArrayList<Parcours>();
		Map<Parcours,Integer> hm = new HashMap<Parcours,Integer>();
		int nbReq = m.size();
		for(Integer mod : m) {
			for(Parcours parcoursi : this.ModuleService.findParcoursByModuleId(mod)) {
				if(!hm.containsKey(parcoursi))
					hm.put(parcoursi,1);
				else {
					int nb = hm.get(parcoursi);
					nb++;
					hm.put(parcoursi,nb);
				}
			}
		}
		for(Parcours p : hm.keySet()) {
			int nb = hm.get(p);
			nb=(int)(nb*100/nbReq);
			hm.put(p,nb);
		}
		model.addAttribute("listParcours", hm);
		model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
		return "parcours";
	}

}