package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.Domaine;

public interface DomaineDAO {

    public void addDomaine(Domaine p);
    public void updateDomaine(Domaine p);
    public List<Domaine> listDomaines();
    public Domaine getDomaineById(int id);
    public void removeDomaine(int id);
}
