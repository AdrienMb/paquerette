package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Prerequis;

public interface PrerequisService {
    public List<Prerequis> listPrerequis();
    public void addPrerequis(Prerequis p);
    public void updatePrerequis(Prerequis p);
    public Prerequis getPrerequisById(int id);
    public void removePrerequis(int id);
}
