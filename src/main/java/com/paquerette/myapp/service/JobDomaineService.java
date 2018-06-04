package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobDomaine;

public interface JobDomaineService {

    public void addJobDomaine(JobDomaine p);
    public void updateJobDomaine(JobDomaine p);
    public List<JobDomaine> listJobDomaine();
    public void removeJobDomaine(int job_id, int domaine_id);
    public JobDomaine getJobDomaineById(int job_id, int domaine_id);

}