package com.paquerette.myapp.model;

import java.io.Serializable;

public class ModulePrerequisPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int module_id;
	private int prerequis_id;
	
	public ModulePrerequisPK() {
		
	}
	public ModulePrerequisPK(int module_id, int prerequis_id) {
		this.module_id = module_id;
		this.prerequis_id = prerequis_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getPrerequis_id() {
		return prerequis_id;
	}
	public void setPrerequis_id(int prerequis_id) {
		this.prerequis_id = prerequis_id;
	}
	
}
