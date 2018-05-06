package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.JobDAO;
import com.paquerette.myapp.model.Job;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO JobDAO;

    public void setJobDAO(JobDAO JobDAO) {
        this.JobDAO = JobDAO;
    }

    @Override
    @Transactional
    public void addJob(Job p) {
        this.JobDAO.addJob(p);
    }

    @Override
    @Transactional
    public void updateJob(Job p) {
        this.JobDAO.updateJob(p);
    }

    @Override
    @Transactional
    public List<Job> listJobs() {
        return this.JobDAO.listJobs();
    }

    @Override
    @Transactional
    public Job getJobById(int id) {
        return this.JobDAO.getJobById(id);
    }

    @Override
    @Transactional
    public void removeJob(int id) {
        this.JobDAO.removeJob(id);
    }

}