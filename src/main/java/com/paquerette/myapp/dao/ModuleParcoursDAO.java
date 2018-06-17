package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.ModuleParcours;

public interface ModuleParcoursDAO {

    public void addModuleParcours(ModuleParcours p);
    public void updateModuleParcours(ModuleParcours p);
    public List<ModuleParcours> listModuleParcours();
    public void removeModuleParcours(int job_id, int domaine_id);
    public ModuleParcours getModuleParcoursById(int job_id, int domaine_id);
}
