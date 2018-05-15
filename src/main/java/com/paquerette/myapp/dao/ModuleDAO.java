package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.Module;
import com.paquerette.myapp.model.Parcours;

public interface ModuleDAO {

    public void addModule(Module p);
    public void updateModule(Module p);
    public List<Module> listModules();
    public Module getModuleById(int id);
    public void removeModule(int id);
    public List<Parcours> findParcoursByModuleId(int id);
}