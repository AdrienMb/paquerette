package com.paquerette.myapp.model;

import java.io.Serializable;

public class JobParcoursPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int job_id;
	private int parcours_id;
	
	public JobParcoursPK() {
		
	}
	public JobParcoursPK(int job_id, int parcours_id) {
		this.job_id = job_id;
		this.parcours_id = parcours_id;
	}
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
	
}
