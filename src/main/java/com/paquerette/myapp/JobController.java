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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.service.JobService;
import com.paquerette.myapp.service.DomaineService;

@Controller
public class JobController {

    private JobService jobService;
    private DomaineService domaineService;

    @Autowired(required = true)
    @Qualifier(value = "jobService")
    public void setJobService(JobService ps) {
        this.jobService = ps;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "domaineService")
    public void setDomaineService(DomaineService ds) {
        this.domaineService = ds;
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String listJobs(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("listDomaines", this.domaineService.listDomaines());
        model.addAttribute("listJobs", this.jobService.listJobs());
        return "job";
    }

    // For add and update Job both
    @RequestMapping(value = "/job/add", method = RequestMethod.POST)
    public String addJob(@ModelAttribute("job") Job p) {

        if (p.getId() == 0) {
            // new Job, add it
            this.jobService.addJob(p);
        } else {
            // existing Job, call update
            this.jobService.updateJob(p);
        }

        return "redirect:/jobs";

    }

    @RequestMapping("/remove/{id}")
    public String removeJob(@PathVariable("id") int id) {
        this.jobService.removeJob(id);
        return "redirect:/jobs";
    }

    @RequestMapping("/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        model.addAttribute("job", this.jobService.getJobById(id));
        model.addAttribute("listJobs", this.jobService.listJobs());
        return "job";
    }
    
    @RequestMapping(value = "/job/findParcoursByJobId", method = RequestMethod.POST)
    public String findParcoursByJobId(@RequestParam("jobsId") List<Integer> j, Model model) {
        List<Job> jobss=new ArrayList<Job>();
		Map<Parcours,Integer> hm = new HashMap<Parcours,Integer>();
		for(Integer job : j) {
			for(Parcours parcoursi : this.jobService.findParcoursByJobId(job)) {
				if(!hm.containsKey(parcoursi))
					hm.put(parcoursi,1);
				else {
					int nb = hm.get(parcoursi);
					nb++;
					hm.put(parcoursi,nb);
				}
			}
		}
		model.addAttribute("listParcours", hm);
		return "parcours";
    }

}