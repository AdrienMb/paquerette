package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Parcours;

public interface JobService {

    public void addJob(Job p);
    public void updateJob(Job p);
    public List<Job> listJobs();
    public Job getJobById(int id);
    public void removeJob(int id);
    public List<Parcours> findParcoursByJobId(int id);

}