package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobParcours;
import com.paquerette.myapp.model.JobParcoursPK;

@Repository("JobParcoursDAO")
public class JobParcoursDAOImpl implements JobParcoursDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobParcoursDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addJobParcours(JobParcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("JobParcours saved successfully, JobParcours Details=" + p);
    }

    @Override
    public void updateJobParcours(JobParcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("JobParcours updated successfully, JobParcours Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<JobParcours> listJobParcours() {
        Session session = this.sessionFactory.getCurrentSession();
        List<JobParcours> jobParcoursList = session.createQuery("from JobParcours").list();
        for (JobParcours p : jobParcoursList) {
            logger.info("JobParcours List::" + p);
        }
        return jobParcoursList;
    }
    
    @Override
    public JobParcours getJobParcoursById(int job_id, int parcours_id) {
    	Session session = this.sessionFactory.getCurrentSession();
    	JobParcoursPK pk = new JobParcoursPK(job_id, parcours_id);
    	JobParcours jobparcours = (JobParcours) session.get(JobParcours.class, pk);
        logger.info("Job parcours loaded successfully, Job parcours details=" + jobparcours);
        return jobparcours;
    }

    @Override
    public void removeJobParcours(int job_id, int parcours_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from JobParcours where job_id = "+job_id+" and parcours_id = "+parcours_id);
        int result = query.executeUpdate();
         
        if (result > 0) {
            System.out.println("Link "+ job_id + " " + parcours_id + " removed");
        }

    }

}