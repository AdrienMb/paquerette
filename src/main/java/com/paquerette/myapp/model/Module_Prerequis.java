package com.paquerette.myapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

//import com.paquerette.myapp.model.Module_PrerequisId;


/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "module_prerequis")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
        joinColumns = @JoinColumn(name = "Prerequis_id")),
    @AssociationOverride(name = "primaryKey.group",
        joinColumns = @JoinColumn(name = "Module_id")) })
public class Module_Prerequis {
	

    @EmbeddedId
    private Module_PrerequisId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("prerequisId")
    private Prerequis prerequis;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("moduleId")
    private Module module;
 
    @Column(name = "typeevaluation")
    private String eval ;
    
    @Column(name = "requis")
    private int requis ;
 
    private Module_Prerequis() {}
 
    public Module_Prerequis(Module module, Prerequis prerequis) {
        this.prerequis = prerequis;
        this.module = module;
        this.id = new Module_PrerequisId(module.getId(), prerequis.getId());
    }

	public Module_PrerequisId getId() {
		return id;
	}

	public void setId(Module_PrerequisId id) {
		this.id = id;
	}

	public Prerequis getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(Prerequis prerequis) {
		this.prerequis = prerequis;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval;
	}

	public int getRequis() {
		return requis;
	}

	public void setRequis(int requis) {
		this.requis = requis;
	}
    
}