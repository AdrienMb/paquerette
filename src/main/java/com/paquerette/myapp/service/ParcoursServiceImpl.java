package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.ParcoursDAO;
import com.paquerette.myapp.model.Parcours;

@Service
public class ParcoursServiceImpl implements ParcoursService {

    @Autowired
    private ParcoursDAO parcoursDAO;

    public void setParcoursDAO(ParcoursDAO parcoursDAO) {
        this.parcoursDAO = parcoursDAO;
    }

    @Override
    @Transactional
    public void addParcours(Parcours p) {
        this.parcoursDAO.addParcours(p);
    }

    @Override
    @Transactional
    public void updateParcours(Parcours p) {
        this.parcoursDAO.updateParcours(p);
    }

    @Override
    @Transactional
    public List<Parcours> listParcours() {
        return this.parcoursDAO.listParcours();
    }

    @Override
    @Transactional
    public Parcours getParcoursById(int id) {
        return this.parcoursDAO.getParcoursById(id);
    }

    @Override
    @Transactional
    public void removeParcours(int id) {
        this.parcoursDAO.removeParcours(id);
    }

}