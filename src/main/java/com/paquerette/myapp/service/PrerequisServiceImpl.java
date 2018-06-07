package com.paquerette.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paquerette.myapp.dao.PrerequisDAO;
import com.paquerette.myapp.dao.PrerequisDAOImpl;
import com.paquerette.myapp.model.Prerequis;
import com.paquerette.myapp.model.Prerequis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PrerequisServiceImpl implements PrerequisService {
	private static final Logger logger = LoggerFactory.getLogger(PrerequisService.class);
	
    @Autowired
    private PrerequisDAO prerequisDAO;

    public void setPrerequisDAO(PrerequisDAO prerequisDAO) {
        this.prerequisDAO = prerequisDAO;
    }

	@Override
	@Transactional
//	public List<Prerequis> getAllPrerequis() {
//		logger.info("######################SERVICE#########################################");
////		return null;
//        return this.prerequisDAO.getAllPrerequis();
//	}
	public List<Prerequis> getAllPrerequis() {
		logger.info("######################SERVICE#########################################");
        return prerequisDAO.getAllPrerequis();
	}


}