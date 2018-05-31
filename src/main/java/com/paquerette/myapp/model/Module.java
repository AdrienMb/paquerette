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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "Module")
public class Module {

    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "module_name")
    private String name;
    
    @Column(name = "module_description")
    private String desc;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Module_Parcours", 
        joinColumns = { @JoinColumn(name = "module_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "parcours_id") }
    )
    List<Parcours> parcoursModule = new ArrayList<Parcours>();


    @OneToMany(
            mappedBy = "module", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
        )
    List<Module_Prerequis> prerequis = new ArrayList<Module_Prerequis>();

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


	@Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name +", desc=" + desc+ "]";
    }

}