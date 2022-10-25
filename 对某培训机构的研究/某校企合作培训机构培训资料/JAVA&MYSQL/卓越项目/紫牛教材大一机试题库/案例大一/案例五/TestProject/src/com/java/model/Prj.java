package com.java.model;

import java.sql.Date;

public class Prj {
	private int prj_id;
	private String prj_name;
	private int prj_cycle;
	private int prj_count;
	private String prj_manager;
//	private  Date  hjashda;
	
	public int getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public int getPrj_cycle() {
		return prj_cycle;
	}
	public void setPrj_cycle(int prj_cycle) {
		this.prj_cycle = prj_cycle;
	}
	public int getPrj_count() {
		return prj_count;
	}
	public void setPrj_count(int prj_count) {
		this.prj_count = prj_count;
	}
	public String getPrj_manager() {
		return prj_manager;
	}
	public void setPrj_manager(String prj_manager) {
		this.prj_manager = prj_manager;
	}

}
