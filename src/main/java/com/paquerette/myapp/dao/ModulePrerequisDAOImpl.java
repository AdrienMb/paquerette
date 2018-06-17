package com.paquerette.myapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.paquerette.myapp.model.ModulePrerequis;
import com.paquerette.myapp.model.ModulePrerequisPK;

@Repository("ModulePrerequisDAO")
public class ModulePrerequisDAOImpl implements ModulePrerequisDAO {

    private static final Logger logger = LoggerFactory.getLogger(ModulePrerequisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addModulePrerequis(ModulePrerequis p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("ModulePrerequis saved successfully, ModulePrerequis Details=" + p);
    }

    @Override
    public void updateModulePrerequis(ModulePrerequis p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("ModulePrerequis updated successfully, ModulePrerequis Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ModulePrerequis> listModulePrerequis() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ModulePrerequis> ModulePrerequisList = session.createQuery("from ModulePrerequis").list();
        for (ModulePrerequis p : ModulePrerequisList) {
            logger.info("ModulePrerequis List::" + p);
        }
        return ModulePrerequisList;
    }
    
    @Override
    public ModulePrerequis getModulePrerequisById(int module_id, int prerequis_id) {
    	Session session = this.sessionFactory.getCurrentSession();
    	ModulePrerequisPK pk = new ModulePrerequisPK(module_id, prerequis_id);
    	ModulePrerequis ModulePrerequis = (ModulePrerequis) session.get(ModulePrerequis.class, pk);
        logger.info("Job Domaine loaded successfully, Job Domaine details=" + ModulePrerequis);
        return ModulePrerequis;
    }

    @Override
    public void removeModulePrerequis(int module_id, int prerequis_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from ModulePrerequis where module_id = "+module_id+" and prerequis_id = "+prerequis_id);
        int result = query.executeUpdate();
         
        if (result > 0) {
            System.out.println("Link "+ module_id + " " + prerequis_id + " removed");
        }

    }

}