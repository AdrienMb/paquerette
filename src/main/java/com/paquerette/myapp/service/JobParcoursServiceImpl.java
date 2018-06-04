package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.JobParcoursDAO;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobParcours;

@Service
public class JobParcoursServiceImpl implements JobParcoursService {

    @Autowired
    private JobParcoursDAO JobParcoursDAO;

    public void setJobParcoursDAO(JobParcoursDAO JobParcoursDAO) {
        this.JobParcoursDAO = JobParcoursDAO;
    }
    
    @Override
    @Transactional
    public JobParcours getJobParcoursById(int job_id, int parcours_id) {
    	return this.JobParcoursDAO.getJobParcoursById(job_id, parcours_id);
    }

    @Override
    @Transactional
    public void addJobParcours(JobParcours p) {
        this.JobParcoursDAO.addJobParcours(p);
    }

    @Override
    @Transactional
    public void updateJobParcours(JobParcours p) {
        this.JobParcoursDAO.updateJobParcours(p);
    }

    @Override
    @Transactional
    public List<JobParcours> listJobParcours() {
        return this.JobParcoursDAO.listJobParcours();
    }

    @Override
    @Transactional
    public void removeJobParcours(int job_id, int parcours_id) {
        this.JobParcoursDAO.removeJobParcours(job_id, parcours_id);
    }
}