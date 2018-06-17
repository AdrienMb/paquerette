package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Prerequis;

@Repository("prerequisDAO")
public class PrerequisDAOImpl implements PrerequisDAO {

    private static final Logger logger = LoggerFactory.getLogger(PrerequisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

	@Override
	public List<Prerequis> listPrerequis() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Prerequis> p = session.createQuery("from Prerequis").list();
        for (Prerequis i:p) {
        	logger.info("Prerequis List::" + i.getModule());
        }
        ;
		return p;
	}
	
	@Override
    public void addPrerequis(Prerequis p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Prerequis saved successfully, Prerequis Details=" + p);
    }

    @Override
    public void updatePrerequis(Prerequis p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Prerequis updated successfully, Prerequis Details=" + p);
    }

    @Override
    public Prerequis getPrerequisById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Prerequis p = (Prerequis) session.load(Prerequis.class, new Integer(id));
        logger.info("Prerequis loaded successfully, Prerequis details=" + p);
        return p;
    }

    @Override
    public void removePrerequis(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Prerequis p = (Prerequis) session.load(Prerequis.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Prerequis deleted successfully, Prerequis details=" + p);
    }

}