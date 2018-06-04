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
@Table(name = "JOB_DOMAINE")
@IdClass(JobDomainePK.class)
public class JobDomaine {
	
	@Id
    @Column(name = "job_id")
    private int job_id;

	@Id
    @Column(name = "domaine_id")
    private int domaine_id;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getDomaine_id() {
		return domaine_id;
	}

	public void setDomaine_id(int domaine_id) {
		this.domaine_id = domaine_id;
	}

	@Override
    public String toString() {
        return "Job_domaine [id=" + job_id + ", domaine_id=" + domaine_id +"]";
    }

}