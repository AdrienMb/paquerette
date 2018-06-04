package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Parcours;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addJob(Job p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Job saved successfully, Job Details=" + p);
    }

    @Override
    public void updateJob(Job p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Job updated successfully, Job Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Job> listJobs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Job> JobsList = session.createQuery("from Job").list();
        for (Job p : JobsList) {
            logger.info("Job List::" + p + "job's domaines: " + p.getDomaines());
        }
        return JobsList;
    }

    @Override
    public Job getJobById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Job p = (Job) session.load(Job.class, new Integer(id));
        logger.info("Job loaded successfully, Job details=" + p);
        return p;
    }

    @Override
    public void removeJob(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Job p = (Job) session.load(Job.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Job deleted successfully, Job details=" + p);
    }
    
    @Override
    @Transactional
    public List<Parcours> findParcoursByJobId(int id) {
    	Session session = this.sessionFactory.getCurrentSession();
        Job j = (Job) session.load(Job.class, new Integer(id));
        List<Parcours> ParcourssList = j.getParcours();
        for (Parcours p : ParcourssList) {
            logger.info("Parcours List::" + p);
        }
        return ParcourssList;
    }

}