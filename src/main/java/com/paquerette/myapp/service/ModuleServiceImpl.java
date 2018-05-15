package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.ModuleDAO;
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDAO ModuleDAO;

    public void setModuleDAO(ModuleDAO ModuleDAO) {
        this.ModuleDAO = ModuleDAO;
    }

    @Override
    @Transactional
    public void addModule(Module p) {
        this.ModuleDAO.addModule(p);
    }

    @Override
    @Transactional
    public void updateModule(Module p) {
        this.ModuleDAO.updateModule(p);
    }

    @Override
    @Transactional
    public List<Module> listModules() {
        return this.ModuleDAO.listModules();
    }

    @Override
    @Transactional
    public Module getModuleById(int id) {
        return this.ModuleDAO.getModuleById(id);
    }

    @Override
    @Transactional
    public void removeModule(int id) {
        this.ModuleDAO.removeModule(id);
    }

	@Override
	public List<Parcours> findParcoursByModuleId(int id) {
		return this.ModuleDAO.findParcoursByModuleId(id);
	}

}