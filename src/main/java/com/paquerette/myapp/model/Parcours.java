package com.paquerette.myapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "PARCOURS")
public class Parcours {

    @Id
    @Column(name = "parcours_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "parcours_name")
    private String name;
    
    @Column(name = "parcours_link_isep")
    private String link;
    
    @ManyToMany(mappedBy = "parcours")
    private List<Job> jobs = new ArrayList<Job>();
    
    @ManyToMany(mappedBy = "parcoursModule")
    private List<Module> modules = new ArrayList<Module>();

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}

	@Override
    public String toString() {
        return "Parcours [id=" + id + ", name=" + name + "link= "+ link +"]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcours other = (Parcours) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}