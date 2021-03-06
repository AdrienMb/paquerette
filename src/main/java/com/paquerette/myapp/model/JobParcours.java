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
@Table(name = "JOB_PARCOURS")
@IdClass(JobParcoursPK.class)
public class JobParcours {
	
	@Id
    @Column(name = "job_id")
    private int job_id;

	@Id
    @Column(name = "parcours_id")
    private int parcours_id;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getParcours_id() {
		return parcours_id;
	}

	public void setParcours_id(int parcours_id) {
		this.parcours_id = parcours_id;
	}

	@Override
    public String toString() {
        return "Job_parcours [id=" + job_id + ", parcours_id=" + parcours_id +"]";
    }

}