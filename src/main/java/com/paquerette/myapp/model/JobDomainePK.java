package com.paquerette.myapp.model;

import java.io.Serializable;

public class JobDomainePK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int job_id;
	private int domaine_id;
	
	public JobDomainePK() {
		
	}
	public JobDomainePK(int job_id, int domaine_id) {
		this.job_id = job_id;
		this.domaine_id = domaine_id;
	}
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
	
}
