package com.paquerette.myapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.service.PrerequisService;
import com.paquerette.myapp.service.DomaineService;
import com.paquerette.myapp.service.ModuleService;

@Controller
public class PrerequisController {

	private PrerequisService prerequisService;
    private DomaineService domaineService;
    private ModuleService ModuleService;

    @Autowired(required = true)
    @Qualifier("prerequisService")
    public void setPrerequisService(PrerequisService ms) {
        this.prerequisService = ms;
    }
    @Autowired(required = true)
	@Qualifier(value = "moduleService")
	public void setModuleService(ModuleService ms) {
		this.ModuleService = ms;
	}
	@RequestMapping(value = "/prerequis", method = RequestMethod.GET)
	public String getAllPrequis(Model model) {
	model.addAttribute("prerequis", new Prerequis());
   	model.addAttribute("listPrerequis", this.prerequisService.getAllPrerequis());
        return "prerequis";
    }
	@RequestMapping(value = "/prerequis/findParcoursByprerequis", method = RequestMethod.POST)
	public String findParcoursByprerequis(@RequestParam("id") List<Integer> ids,@RequestParam("requis") List<Integer> r ,Model model) {
//		List<Module> listModule = this.ModuleService.listModules();
		List<Prerequis> listPrerequis = this.prerequisService.getAllPrerequis();
		List<Integer> modules = new ArrayList<Integer>();
		Map<Parcours,Integer> hm = new HashMap<Parcours,Integer>();
		for(Prerequis p:listPrerequis){
			for (int i = 0; i<ids.size();i=i+1) {
				if (p.getId()==ids.get(i)) {
					if (r.get(i)>= p.getRequis()) {
						
						for(Module m:p.getModule()) {
							modules.add(m.getId());
						}
					}
				}
			}
		}
		int nbReq = modules.size();
		for(Integer mod : modules) {
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
        return "parcours";
    }
	
}