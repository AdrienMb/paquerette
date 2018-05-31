package com.paquerette.myapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Embeddable
public class Module_PrerequisId implements Serializable {

  
    @Column(name = "Prerequis_id")
    private int prerequis_id;

    public int getPrerequis_id() {
		return prerequis_id;
	}

	public void setPrerequis_id(int prerequis_id) {
		this.prerequis_id = prerequis_id;
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	@Column(name = "module_id")
    private int module_id;
    
    
    private Module_PrerequisId() {}
    
    public Module_PrerequisId(int module_id,int prerequis_id) {
        this.module_id = module_id;
        this.prerequis_id = prerequis_id;
    }
}