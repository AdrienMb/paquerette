package com.paquerette.myapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.PrerequisService;
import com.paquerette.myapp.service.UserServiceImpl;
import com.paquerette.myapp.service.DomaineService;
import com.paquerette.myapp.service.ModuleService;
import com.paquerette.myapp.service.ParcoursService;

@Controller
public class PrerequisController {

	private PrerequisService prerequisService;
    private ModuleService ModuleService;
    private ParcoursService parcoursService;
    
    private final String GOOD_GRADE = "green";
    private final String MEDIUM_GRADE = "yellow";
    private final String BAD_GRADE = "red";
    private final String NA_GRADE = "blue";

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
    @Autowired(required = true)
	@Qualifier(value = "parcoursService")
	public void setParcoursService(ParcoursService ps) {
		this.parcoursService = ps;
	}
	@RequestMapping(value = "/prerequis", method = RequestMethod.GET)
	public String getAllPrequis(Model model, HttpServletRequest request) {
	if (request.getSession().getAttribute("user")==null) return "redirect:/login";
	model.addAttribute("prerequis", new Prerequis());
   	model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
   	model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "prerequis";
    }
	@RequestMapping(value = "/prerequis/findParcoursByprerequis", method = RequestMethod.POST)
	public String findParcoursByprerequis(@RequestParam("id") List<Integer> ids,@RequestParam("requis") List<Integer> r ,Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("user")==null) return "redirect:/login";
		Map<Parcours,Integer> parcours_score = new HashMap<Parcours,Integer>();
		List<Parcours> parcours = parcoursService.listParcours();
		Map<Parcours, Map<Prerequis, String>> parcours_notes = new HashMap<Parcours, Map<Prerequis, String>>();
		
		for (Parcours p : parcours) {
			parcours_score.put(p, 0);
			Map<Prerequis, String> prerequis_notes = new HashMap<Prerequis, String>();
			for (Module m : p.getModules()) {
				for (Prerequis pr : m.getPrerequis()) {
					if (ids.contains(pr.getId())) {
						Integer note = r.get(ids.indexOf(pr.getId()));
						if (prerequis_notes.containsKey(pr)) {
							String current_color = prerequis_notes.get(pr);
							if (current_color.equals(GOOD_GRADE) && note == pr.getRequis()) {
								prerequis_notes.put(pr, MEDIUM_GRADE);
							} else if ((current_color.equals(GOOD_GRADE) || current_color.equals(MEDIUM_GRADE)) && note < pr.getRequis()) {
								prerequis_notes.put(pr, BAD_GRADE);
							}
						} else {
							if ( note > pr.getRequis()) {
								prerequis_notes.put(pr, GOOD_GRADE);
							} else if ( note == pr.getRequis()) {
								prerequis_notes.put(pr, MEDIUM_GRADE);
							} else {
								prerequis_notes.put(pr, BAD_GRADE);
							}
						}
					} else {
						prerequis_notes.put(pr, NA_GRADE);
					}
				}
			}
			int nb_prerequis = prerequis_notes.keySet().size();
			int nb_validate_pr = 0;
			for (Prerequis pr : prerequis_notes.keySet()) {
				if (prerequis_notes.get(pr).equals(GOOD_GRADE) || prerequis_notes.get(pr).equals(MEDIUM_GRADE)) {
					nb_validate_pr++;
				}
			}
			int score = nb_prerequis > 0 ? (int)(nb_validate_pr*100/nb_prerequis) : 100;
			parcours_score.put(p, score);
			parcours_notes.put(p, prerequis_notes);
		}
		
		model.addAttribute("listParcours", parcours_score);
		model.addAttribute("parcoursNotes", parcours_notes);
		model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "parcours";
    }
	
}