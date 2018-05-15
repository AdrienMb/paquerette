package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;

@Repository("ModuleDAO")
public class ModuleDAOImpl implements ModuleDAO {

    private static final Logger logger = LoggerFactory.getLogger(ModuleDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addModule(Module m) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(m);
        logger.info("Module saved successfully, Module Details=" + m);
    }

    @Override
    public void updateModule(Module m) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(m);
        logger.info("Module updated successfully, Module Details=" + m);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Module> listModules() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Module> ModulesList = session.createQuery("from Module").list();
        for (Module m : ModulesList) {
            logger.info("Module List::" + m);
        }
        return ModulesList;
    }

    @Override
    public Module getModuleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Module m = (Module) session.load(Module.class, new Integer(id));
        logger.info("Module loaded successfully, Module details=" + m);
        return m;
    }

    @Override
    public void removeModule(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Module m = (Module) session.load(Module.class, new Integer(id));
        if (null != m) {
            session.delete(m);
        }
        logger.info("Module deleted successfully, Module details=" + m);
    }

	@Override
	@Transactional
	public List<Parcours> findParcoursByModuleId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Module m = (Module) session.load(Module.class, new Integer(id));
        List<Parcours> ParcourssList = m.getParcours();
        for (Parcours p : ParcourssList) {
            logger.info("Parcours List::" + p);
        }
        return ParcourssList;
	}

}