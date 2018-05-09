package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.DomaineDAO;
import com.paquerette.myapp.model.Domaine;

@Service
public class DomaineServiceImpl implements DomaineService {

    @Autowired
    private DomaineDAO DomaineDAO;

    public void setDomaineDAO(DomaineDAO DomaineDAO) {
        this.DomaineDAO = DomaineDAO;
    }

    @Override
    @Transactional
    public void addDomaine(Domaine p) {
        this.DomaineDAO.addDomaine(p);
    }

    @Override
    @Transactional
    public void updateDomaine(Domaine p) {
        this.DomaineDAO.updateDomaine(p);
    }

    @Override
    @Transactional
    public List<Domaine> listDomaines() {
        return this.DomaineDAO.listDomaines();
    }

    @Override
    @Transactional
    public Domaine getDomaineById(int id) {
        return this.DomaineDAO.getDomaineById(id);
    }

    @Override
    @Transactional
    public void removeDomaine(int id) {
        this.DomaineDAO.removeDomaine(id);
    }
}