package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.ModulePrerequisDAO;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.ModulePrerequis;

@Service
public class ModulePrerequisServiceImpl implements ModulePrerequisService {

    @Autowired
    private ModulePrerequisDAO ModulePrerequisDAO;

    public void setModulePrerequisDAO(ModulePrerequisDAO ModulePrerequisDAO) {
        this.ModulePrerequisDAO = ModulePrerequisDAO;
    }
    
    @Override
    @Transactional
    public ModulePrerequis getModulePrerequisById(int module_id, int prerequis_id) {
    	return this.ModulePrerequisDAO.getModulePrerequisById(module_id, prerequis_id);
    }

    @Override
    @Transactional
    public void addModulePrerequis(ModulePrerequis p) {
        this.ModulePrerequisDAO.addModulePrerequis(p);
    }

    @Override
    @Transactional
    public void updateModulePrerequis(ModulePrerequis p) {
        this.ModulePrerequisDAO.updateModulePrerequis(p);
    }

    @Override
    @Transactional
    public List<ModulePrerequis> listModulePrerequis() {
        return this.ModulePrerequisDAO.listModulePrerequis();
    }

    @Override
    @Transactional
    public void removeModulePrerequis(int module_id, int prerequis_id) {
        this.ModulePrerequisDAO.removeModulePrerequis(module_id, prerequis_id);
    }
}