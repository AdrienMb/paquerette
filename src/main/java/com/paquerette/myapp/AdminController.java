package com.paquerette.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobDomaine;
import com.paquerette.myapp.model.JobParcours;
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.ModuleParcours;
import com.paquerette.myapp.model.ModulePrerequis;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.User;
import com.paquerette.myapp.service.JobService;
import com.paquerette.myapp.service.ModuleParcoursService;
import com.paquerette.myapp.service.ModulePrerequisService;
import com.paquerette.myapp.service.ModuleService;
import com.paquerette.myapp.service.ParcoursService;
import com.paquerette.myapp.service.PrerequisService;
import com.paquerette.myapp.service.UserServiceImpl;
import com.paquerette.myapp.service.DomaineService;
import com.paquerette.myapp.service.JobDomaineService;
import com.paquerette.myapp.service.JobParcoursService;

@Controller
public class AdminController {

    private JobService jobService;
    private DomaineService domaineService;
    private JobParcoursService jobParcoursService;
    private ParcoursService parcoursService;
    private JobDomaineService jobDomaineService;
    private ModuleService moduleService;
    private ModuleParcoursService moduleParcoursService;
    private ModulePrerequisService modulePrerequisService;
    private PrerequisService prerequisService;

    @Autowired(required = true)
    @Qualifier(value = "jobService")
    public void setJobService(JobService ps) {
        this.jobService = ps;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "prerequisService")
    public void setPrerequisService(PrerequisService ps) {
        this.prerequisService = ps;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "moduleService")
    public void setModuleService(ModuleService ms) {
        this.moduleService = ms;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "moduleParcoursService")
    public void setModuleParcoursService(ModuleParcoursService mps) {
        this.moduleParcoursService= mps;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "modulePrerequisService")
    public void setModulePrerequisService(ModulePrerequisService mps) {
        this.modulePrerequisService = mps;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "domaineService")
    public void setDomaineService(DomaineService ds) {
        this.domaineService = ds;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "jobParcoursService")
    public void setJobParcoursService(JobParcoursService ds) {
        this.jobParcoursService = ds;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "parcoursService")
    public void setParcoursService(ParcoursService js) {
        this.parcoursService = js;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "jobDomaineService")
    public void setJobDomaineService(JobDomaineService jds) {
        this.jobDomaineService = jds;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listJobs(Model model, HttpServletRequest request) {
        model.addAttribute("job", new Job());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("domaine", new Domaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", new Prerequis());
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        User user = (User) request.getSession().getAttribute("user");
        if (UserServiceImpl.isAdmin(user)) {
        	model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));	
        	return "admin";
        }
        else {
        	return "redirect:/";
        }
    }

    // For add and update Job both
    @RequestMapping(value = "admin/jobs/add", method = RequestMethod.POST)
    public String addJob(@ModelAttribute("job") Job p) {

        if (p.getId() == 0) {
            // new Job, add it
            this.jobService.addJob(p);
        } else {
            // existing Job, call update
            this.jobService.updateJob(p);
        }

        return "redirect:/admin";

    }
    
    @RequestMapping(value = "admin/jobparcours/add", method = RequestMethod.POST)
    public String addJobParcours(@ModelAttribute("jobparcours") JobParcours p) {
    	this.jobParcoursService.addJobParcours(p);
        return "redirect:/admin";

    }
    
    // For add and update Job both
    @RequestMapping(value = "admin/parcours/add", method = RequestMethod.POST)
    public String addParcours(@ModelAttribute("parcours") Parcours p) {

        if (p.getId() == 0) {
            // new Job, add it
            this.parcoursService.addParcours(p);
        } else {
            // existing Job, call update
            this.parcoursService.updateParcours(p);
        }

        return "redirect:/admin";

    }

    @RequestMapping("admin/parcours/remove/{id}")
    public String removeParcours(@PathVariable("id") int id) {
        this.parcoursService.removeParcours(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/parcours/edit/{id}")
    public String editParcours(@PathVariable("id") int id, Model model,HttpServletRequest request) {
        model.addAttribute("parcours", this.parcoursService.getParcoursById(id));
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("job", new Job());
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("domaine", new Domaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", new Prerequis());
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "admin";
    }
    
    @RequestMapping(value = "/admin/jobparcours/remove/{job_id}/parcours_id/{parcours_id}", method = RequestMethod.GET)
    public String removeJobParcours(@PathVariable("job_id") int job_id, @PathVariable("parcours_id") int parcours_id) {
    	this.jobParcoursService.removeJobParcours(job_id, parcours_id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/jobs/remove/{id}", method = RequestMethod.GET)
    public String removeJob(@PathVariable("id") int id) {
        this.jobService.removeJob(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/jobs/edit/{id}", method = RequestMethod.GET)
    public String editJob(@PathVariable("id") int id, Model model,HttpServletRequest request) {
        model.addAttribute("job", this.jobService.getJobById(id));
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("domaine", new Domaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", new Prerequis());
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "admin";
    }
    
    // For add and update domaine both
    @RequestMapping(value = "admin/domaines/add", method = RequestMethod.POST)
    public String addDomaine(@ModelAttribute("domaine") Domaine p) {

        if (p.getId() == 0) {
            // new domaine, add it
            this.domaineService.addDomaine(p);
        } else {
            // existing domaine, call update
            this.domaineService.updateDomaine(p);
        }

        return "redirect:/admin";

    }

    @RequestMapping("admin/domaines/remove/{id}")
    public String removeDomaine(@PathVariable("id") int id) {
        this.domaineService.removeDomaine(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/domaines/edit/{id}")
    public String editDomaine(@PathVariable("id") int id, Model model,HttpServletRequest request) {
        model.addAttribute("domaine", this.domaineService.getDomaineById(id));
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("job", new Job());
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", new Prerequis());
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "admin";
    }
    
 // For add and update module both
    @RequestMapping(value = "admin/modules/add", method = RequestMethod.POST)
    public String addModule(@ModelAttribute("module") Module m) {

        if (m.getId() == 0) {
            // new Job, add it
            this.moduleService.addModule(m);
        } else {
            // existing Job, call update
            this.moduleService.updateModule(m);
        }

        return "redirect:/admin";

    }

    @RequestMapping("admin/modules/remove/{id}")
    public String removeModule(@PathVariable("id") int id) {
        this.moduleService.removeModule(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/modules/edit/{id}")
    public String editModule(@PathVariable("id") int id, Model model,HttpServletRequest request) {
    	model.addAttribute("domaine", new Domaine());
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("job", new Job());
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("module", this.moduleService.getModuleById(id));
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", new Prerequis());
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "admin";
    }
    
    @RequestMapping(value = "/admin/jobdomaine/remove/{job_id}/domaine_id/{domaine_id}", method = RequestMethod.GET)
    public String removeJobDomaine(@PathVariable("job_id") int job_id, @PathVariable("domaine_id") int domaine_id) {
    	this.jobDomaineService.removeJobDomaine(job_id, domaine_id);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "admin/jobdomaine/add", method = RequestMethod.POST)
    public String addJobDomaine(@ModelAttribute("jobdomaine") JobDomaine p) {
    	this.jobDomaineService.addJobDomaine(p);
        return "redirect:/admin";

    }
    
    @RequestMapping(value = "/admin/moduleparcours/remove/{module_id}/parcours_id/{parcours_id}", method = RequestMethod.GET)
    public String removeModuleParcours(@PathVariable("module_id") int module_id, @PathVariable("parcours_id") int parcours_id) {
    	this.moduleParcoursService.removeModuleParcours(module_id, parcours_id);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "admin/moduleparcours/add", method = RequestMethod.POST)
    public String addModuleParcours(@ModelAttribute("moduleparcours") ModuleParcours mp) {
    	this.moduleParcoursService.addModuleParcours(mp);
        return "redirect:/admin";

    }
    
    @RequestMapping(value = "/admin/moduleprerequis/remove/{module_id}/prerequis_id/{prerequis_id}", method = RequestMethod.GET)
    public String removeModulePrerequis(@PathVariable("module_id") int module_id, @PathVariable("prerequis_id") int prerequis_id) {
    	this.modulePrerequisService.removeModulePrerequis(module_id, prerequis_id);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "admin/moduleprerequis/add", method = RequestMethod.POST)
    public String addModulePrerequis(@ModelAttribute("moduleprerequis") ModulePrerequis mp) {
    	this.modulePrerequisService.addModulePrerequis(mp);
        return "redirect:/admin";

    }
    
    // For add and update prerequis both
    @RequestMapping(value = "admin/prerequis/add", method = RequestMethod.POST)
    public String addPrerequis(@ModelAttribute("module") Prerequis m) {

        if (m.getId() == 0) {
            // new Job, add it
            this.prerequisService.addPrerequis(m);
        } else {
            // existing Job, call update
            this.prerequisService.updatePrerequis(m);
        }

        return "redirect:/admin";

    }

    @RequestMapping("admin/prerequis/remove/{id}")
    public String removePrerequis(@PathVariable("id") int id) {
        this.prerequisService.removePrerequis(id);
        return "redirect:/admin";
    }

    @RequestMapping("admin/prerequis/edit/{id}")
    public String editPrerequis(@PathVariable("id") int id, Model model,HttpServletRequest request) {
    	model.addAttribute("domaine", new Domaine());
        model.addAttribute("jobdomaine", new JobDomaine());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("job", new Job());
        model.addAttribute("listJobs", this.jobService.listJobs());
        model.addAttribute("jobparcours", new JobParcours());
        model.addAttribute("parcours", new Parcours());
        model.addAttribute("listParcours", this.parcoursService.listParcours());
        model.addAttribute("listJobParcours", this.jobParcoursService.listJobParcours());
        model.addAttribute("listJobDomaines", this.jobDomaineService.listJobDomaine());
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());
        model.addAttribute("moduleparcours", new ModuleParcours());
        model.addAttribute("listModuleParcours", this.moduleParcoursService.listModuleParcours());
        model.addAttribute("moduleprerequis", new ModulePrerequis());
        model.addAttribute("listModulePrerequis", this.modulePrerequisService.listModulePrerequis());
        model.addAttribute("prerequis", this.prerequisService.getPrerequisById(id));
        model.addAttribute("listPrerequis", this.prerequisService.listPrerequis());
        model.addAttribute("isAdmin", UserServiceImpl.isAdmin((User) request.getSession().getAttribute("user")));
        return "admin";
    }

}