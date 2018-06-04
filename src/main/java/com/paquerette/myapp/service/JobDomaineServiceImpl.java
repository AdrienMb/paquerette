package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.JobDomaineDAO;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobDomaine;

@Service
public class JobDomaineServiceImpl implements JobDomaineService {

    @Autowired
    private JobDomaineDAO JobDomaineDAO;

    public void setJobDomaineDAO(JobDomaineDAO JobDomaineDAO) {
        this.JobDomaineDAO = JobDomaineDAO;
    }
    
    @Override
    @Transactional
    public JobDomaine getJobDomaineById(int job_id, int Domaine_id) {
    	return this.JobDomaineDAO.getJobDomaineById(job_id, Domaine_id);
    }

    @Override
    @Transactional
    public void addJobDomaine(JobDomaine p) {
        this.JobDomaineDAO.addJobDomaine(p);
    }

    @Override
    @Transactional
    public void updateJobDomaine(JobDomaine p) {
        this.JobDomaineDAO.updateJobDomaine(p);
    }

    @Override
    @Transactional
    public List<JobDomaine> listJobDomaine() {
        return this.JobDomaineDAO.listJobDomaine();
    }

    @Override
    @Transactional
    public void removeJobDomaine(int job_id, int domaine_id) {
        this.JobDomaineDAO.removeJobDomaine(job_id, domaine_id);
    }
}