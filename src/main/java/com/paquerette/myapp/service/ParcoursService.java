package com.paquerette.myapp.service;

import java.util.List;

import com.paquerette.myapp.model.Parcours;

public interface ParcoursService {

    public void addParcours(Parcours p);
    public void updateParcours(Parcours p);
    public List<Parcours> listParcours();
    public Parcours getParcoursById(int id);
    public void removeParcours(int id);

}