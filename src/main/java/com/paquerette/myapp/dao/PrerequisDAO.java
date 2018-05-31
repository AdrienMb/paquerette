package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Module_Prerequis;

public interface PrerequisDAO {

    public List<Module_Prerequis> getAllPrerequis();
}