package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Parcours;
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
	public List<Prerequis> getAllPrerequis() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Prerequis> p = session.createQuery("from Prerequis").list();
        for (Prerequis i:p) {
        	logger.info("Parcours List::" + i.getModule());
        }
        ;
		return p;
	}

}