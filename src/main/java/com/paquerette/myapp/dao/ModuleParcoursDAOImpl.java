package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.ModuleParcours;
import com.paquerette.myapp.model.ModuleParcoursPK;

@Repository("ModuleParcoursDAO")
public class ModuleParcoursDAOImpl implements ModuleParcoursDAO {

    private static final Logger logger = LoggerFactory.getLogger(ModuleParcoursDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addModuleParcours(ModuleParcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("ModuleParcours saved successfully, ModuleParcours Details=" + p);
    }

    @Override
    public void updateModuleParcours(ModuleParcours p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("ModuleParcours updated successfully, ModuleParcours Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ModuleParcours> listModuleParcours() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ModuleParcours> ModuleParcoursList = session.createQuery("from ModuleParcours").list();
        for (ModuleParcours p : ModuleParcoursList) {
            logger.info("ModuleParcours List::" + p);
        }
        return ModuleParcoursList;
    }
    
    @Override
    public ModuleParcours getModuleParcoursById(int module_id, int parcours_id) {
    	Session session = this.sessionFactory.getCurrentSession();
    	ModuleParcoursPK pk = new ModuleParcoursPK(module_id, parcours_id);
    	ModuleParcours ModuleParcours = (ModuleParcours) session.get(ModuleParcours.class, pk);
        logger.info("Module parcours loaded successfully, Module parcours details=" + ModuleParcours);
        return ModuleParcours;
    }

    @Override
    public void removeModuleParcours(int module_id, int parcours_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from ModuleParcours where module_id = "+module_id+" and parcours_id = "+parcours_id);
        int result = query.executeUpdate();
         
        if (result > 0) {
            System.out.println("Link "+ module_id + " " + parcours_id + " removed");
        }

    }

}