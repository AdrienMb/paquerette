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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "MODULE")
public class Module {

    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "module_name")
    private String name;
    
    @Column(name = "module_description")
    private String desc;

    @Transient
    private ArrayList<Integer> modulesId = new ArrayList<Integer>();
    
    @ManyToMany(cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinTable(
        name = "Module_Parcours", 
        joinColumns = { @JoinColumn(name = "module_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "parcours_id") }
    )
    List<Parcours> parcoursModule = new ArrayList<Parcours>();
    
    @ManyToMany(cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinTable(
        name = "Module_Prerequis", 
        joinColumns = { @JoinColumn(name = "module_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "prerequis_id")}
    )
    List<Prerequis> prerequis = new ArrayList<Prerequis>();

    public List<Prerequis> getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(List<Prerequis> prerequis) {
		this.prerequis = prerequis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parcours> getParcours() {
		return parcoursModule;
	}


	@Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name +", desc=" + desc+ "]";
    }

	public List<Integer> getModulesId() {
		return modulesId;
	}

	public void setModulesId(ArrayList<Integer> modules) {
		this.modulesId = modules;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}