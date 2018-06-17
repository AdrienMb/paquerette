package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.ModuleParcours;

public interface ModuleParcoursService {

    public void addModuleParcours(ModuleParcours p);
    public void updateModuleParcours(ModuleParcours p);
    public List<ModuleParcours> listModuleParcours();
    public void removeModuleParcours(int module_id, int parcours_id);
    public ModuleParcours getModuleParcoursById(int module_id, int parcours_id);

}