package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Module_Prerequis;

@Repository("prerequisDAO")
public class PrerequisDAOImpl implements PrerequisDAO {

    private static final Logger logger = LoggerFactory.getLogger(PrerequisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

	@Override
	public List<Module_Prerequis> getAllPrerequis() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Module_Prerequis> p = session.createQuery("select mp from Module_Prerequis mp ,module m,prerequis p where mp.module_id=m.module_id and mp.prerequis_id=p.prerequis_id ").list();
        for (Module_Prerequis i:p) {
        	logger.info("Parcours List::" + i.getModule());
        }
        ;
		return p;
	}

}