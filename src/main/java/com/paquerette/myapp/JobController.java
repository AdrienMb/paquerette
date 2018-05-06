package com.paquerette.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.service.JobService;

@Controller
public class JobController {

    private JobService jobService;

    @Autowired(required = true)
    @Qualifier(value = "jobService")
    public void setJobService(JobService ps) {
        this.jobService = ps;
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String listJobs(Model model) {
        model.addAttribute("job", new Job());
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

}