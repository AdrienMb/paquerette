package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Domaine;

@Repository("DomaineDAO")
public class DomaineDAOImpl implements DomaineDAO {

    private static final Logger logger = LoggerFactory.getLogger(DomaineDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addDomaine(Domaine p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Domaine saved successfully, Domaine Details=" + p);
    }

    @Override
    public void updateDomaine(Domaine p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Domaine updated successfully, Domaine Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Domaine> listDomaines() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Domaine> domainesList = session.createQuery("from Domaine").list();
        for (Domaine p : domainesList) {
            logger.info("Domaine List::" + p);
        }
        return domainesList;
    }

    @Override
    public Domaine getDomaineById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Domaine p = (Domaine) session.load(Domaine.class, new Integer(id));
        logger.info("Domaine loaded successfully, Domaine details=" + p);
        return p;
    }

    @Override
    public void removeDomaine(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Domaine p = (Domaine) session.load(Domaine.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Domaine deleted successfully, Domaine details=" + p);
    }

}