package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.Job;

public interface JobDAO {

    public void addJob(Job p);
    public void updateJob(Job p);
    public List<Job> listJobs();
    public Job getJobById(int id);
    public void removeJob(int id);
}
