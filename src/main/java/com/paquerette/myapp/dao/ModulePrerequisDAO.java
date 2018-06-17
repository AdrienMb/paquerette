package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.ModulePrerequis;

public interface ModulePrerequisDAO {

    public void addModulePrerequis(ModulePrerequis p);
    public void updateModulePrerequis(ModulePrerequis p);
    public List<ModulePrerequis> listModulePrerequis();
    public void removeModulePrerequis(int job_id, int domaine_id);
    public ModulePrerequis getModulePrerequisById(int job_id, int domaine_id);
}
