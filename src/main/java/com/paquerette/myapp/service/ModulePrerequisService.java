package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.ModulePrerequis;

public interface ModulePrerequisService {

    public void addModulePrerequis(ModulePrerequis p);
    public void updateModulePrerequis(ModulePrerequis p);
    public List<ModulePrerequis> listModulePrerequis();
    public void removeModulePrerequis(int module_id, int prerequis_id);
    public ModulePrerequis getModulePrerequisById(int module_id, int prerequis_id);

}