package com.paquerette.myapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "MODULE_PREREQUIS")
@IdClass(ModulePrerequisPK.class)
public class ModulePrerequis {
	
	@Id
    @Column(name = "module_id")
    private int module_id;

	@Id
    @Column(name = "prerequis_id")
    private int prerequis_id;

	@Override
    public String toString() {
        return "Module_prerequis [id=" + module_id + ", prerequis_id=" + prerequis_id +"]";
    }

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public int getPrerequis_id() {
		return prerequis_id;
	}

	public void setPrerequis_id(int prerequis_id) {
		this.prerequis_id = prerequis_id;
	}

}