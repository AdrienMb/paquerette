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
@Table(name = "prerequis")
public class Prerequis {
	
	 
	@Id
    @Column(name = "prerequis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @ManyToMany(cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinTable(
        name = "Module_Prerequis", 
        joinColumns = { @JoinColumn(name = "prerequis_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "module_id")}
    )
    List<Module> module = new ArrayList<Module>();
 	@Column(name = "prerequis_name")
    	private String name ;

    @Column(name = "typeevaluation")
    private String eval ;
    
    @Column(name = "requis")
    private int requis ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
    