package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Module_Prerequis;

public interface PrerequisService {
    public List<Module_Prerequis> getAllPrerequis();
}
