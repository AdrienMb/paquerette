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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "JOB")
public class Job {

    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "job_name")
    private String name;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Job_Parcours", 
        joinColumns = { @JoinColumn(name = "job_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "parcours_id") }
    )
    List<Parcours> parcours = new ArrayList<Parcours>();
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Job_Domaine", 
        joinColumns = { @JoinColumn(name = "job_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "domaine_id") }
    )
    private List<Domaine> domaines = new ArrayList<Domaine>();

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
		return parcours;
	}

	public void setParcours(List<Parcours> parcours) {
		this.parcours = parcours;
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	@Override
    public String toString() {
        return "Job [id=" + id + ", name=" + name + "]";
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
        Job other = (Job) obj;
        if (id != other.id)
            return false;
        return true;
    }

}