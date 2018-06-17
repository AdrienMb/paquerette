package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.ModuleParcoursDAO;
import com.paquerette.myapp.model.ModuleParcours;

@Service
public class ModuleParcoursServiceImpl implements ModuleParcoursService {

    @Autowired
    private ModuleParcoursDAO ModuleParcoursDAO;

    public void setModuleParcoursDAO(ModuleParcoursDAO ModuleParcoursDAO) {
        this.ModuleParcoursDAO = ModuleParcoursDAO;
    }
    
    @Override
    @Transactional
    public ModuleParcours getModuleParcoursById(int module_id, int parcours_id) {
    	return this.ModuleParcoursDAO.getModuleParcoursById(module_id, parcours_id);
    }

    @Override
    @Transactional
    public void addModuleParcours(ModuleParcours p) {
        this.ModuleParcoursDAO.addModuleParcours(p);
    }

    @Override
    @Transactional
    public void updateModuleParcours(ModuleParcours p) {
        this.ModuleParcoursDAO.updateModuleParcours(p);
    }

    @Override
    @Transactional
    public List<ModuleParcours> listModuleParcours() {
        return this.ModuleParcoursDAO.listModuleParcours();
    }

    @Override
    @Transactional
    public void removeModuleParcours(int module_id, int parcours_id) {
        this.ModuleParcoursDAO.removeModuleParcours(module_id, parcours_id);
    }
}