package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Parcours;

@Repository("parcoursDAO")
public class ParcoursDAOImpl implements ParcoursDAO {

    private static final Logger logger = LoggerFactory.getLogger(ParcoursDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addParcours(Parcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Parcours saved successfully, Parcours Details=" + p);
    }

    @Override
    public void updateParcours(Parcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Parcours updated successfully, Parcours Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Parcours> listParcours() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Parcours> ParcourssList = session.createQuery("from Parcours").list();
        for (Parcours p : ParcourssList) {
            logger.info("Parcours List::" + p);
        }
        return ParcourssList;
    }

    @Override
    public Parcours getParcoursById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parcours p = (Parcours) session.load(Parcours.class, new Integer(id));
        logger.info("Parcours loaded successfully, Parcours details=" + p);
        return p;
    }

    @Override
    public void removeParcours(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parcours p = (Parcours) session.load(Parcours.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Parcours deleted successfully, Parcours details=" + p);
    }

}