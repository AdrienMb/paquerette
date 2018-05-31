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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "Prerequis")
public class Prerequis {

    @Id
    @Column(name = "Prerequis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Prerequis_name")
    private String name;
    
    @OneToMany(
            mappedBy = "prerequis", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
        )
    private List<Module_Prerequis> modules = new ArrayList<Module_Prerequis>();

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

	public List<Module_Prerequis> getModules() {
		return modules;
	}

	public void setModules(List<Module_Prerequis> modules) {
		this.modules = modules;
	}
    
}