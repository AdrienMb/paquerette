package com.paquerette.myapp.dao;

import java.util.List;

import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Parcours;
import com.paquerette.myapp.model.Prerequis;

public interface PrerequisDAO {

    public List<Prerequis> listPrerequis();
    public void addPrerequis(Prerequis p);
    public void updatePrerequis(Prerequis p);
    public Prerequis getPrerequisById(int id);
    public void removePrerequis(int id);
}