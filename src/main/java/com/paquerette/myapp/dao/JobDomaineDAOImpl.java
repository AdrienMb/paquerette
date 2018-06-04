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
import com.paquerette.myapp.model.JobDomaine;
import com.paquerette.myapp.model.JobDomainePK;

@Repository("JobDomaineDAO")
public class JobDomaineDAOImpl implements JobDomaineDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobDomaineDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addJobDomaine(JobDomaine p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("JobDomaine saved successfully, JobDomaine Details=" + p);
    }

    @Override
    public void updateJobDomaine(JobDomaine p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("JobDomaine updated successfully, JobDomaine Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<JobDomaine> listJobDomaine() {
        Session session = this.sessionFactory.getCurrentSession();
        List<JobDomaine> jobDomaineList = session.createQuery("from JobDomaine").list();
        for (JobDomaine p : jobDomaineList) {
            logger.info("JobDomaine List::" + p);
        }
        return jobDomaineList;
    }
    
    @Override
    public JobDomaine getJobDomaineById(int job_id, int domaine_id) {
    	Session session = this.sessionFactory.getCurrentSession();
    	JobDomainePK pk = new JobDomainePK(job_id, domaine_id);
    	JobDomaine jobDomaine = (JobDomaine) session.get(JobDomaine.class, pk);
        logger.info("Job Domaine loaded successfully, Job Domaine details=" + jobDomaine);
        return jobDomaine;
    }

    @Override
    public void removeJobDomaine(int job_id, int domaine_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from JobDomaine where job_id = "+job_id+" and domaine_id = "+domaine_id);
        int result = query.executeUpdate();
         
        if (result > 0) {
            System.out.println("Link "+ job_id + " " + domaine_id + " removed");
        }

    }

}