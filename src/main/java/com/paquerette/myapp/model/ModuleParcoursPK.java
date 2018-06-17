package com.paquerette.myapp.model;

import java.io.Serializable;

public class ModuleParcoursPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int module_id;
	private int parcours_id;
	
	public ModuleParcoursPK() {
		
	}
	public ModuleParcoursPK(int module_id, int parcours_id) {
		this.module_id = module_id;
		this.parcours_id = parcours_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getParcours_id() {
		return parcours_id;
	}
	public void setParcours_id(int parcours_id) {
		this.parcours_id = parcours_id;
	}
	
}
