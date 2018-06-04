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

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "DOMAINE")
public class Domaine {

    @Id
    @Column(name = "domaine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "domaine_name")
    private String name;
    
    @ManyToMany(cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinTable(
        name = "Job_Domaine", 
        joinColumns = { @JoinColumn(name = "domaine_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "job_id") }
    )
    List<Job> jobs = new ArrayList<Job>();

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

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
    public String toString() {
        return "Domaine [id=" + id + ", name=" + name +"]";
    }

}