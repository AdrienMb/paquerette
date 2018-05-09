package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Domaine;

public interface DomaineService {

    public void addDomaine(Domaine p);
    public void updateDomaine(Domaine p);
    public List<Domaine> listDomaines();
    public Domaine getDomaineById(int id);
    public void removeDomaine(int id);

}