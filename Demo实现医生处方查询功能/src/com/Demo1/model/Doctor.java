package com.Demo1.model;

public class Doctor {
	private int ID;
	private String dname;
	private String dept;
	private String pym;
	public Doctor() {}
	 
	 public Doctor(int ID,String dname, String dept,String pym) {
		 this.ID=ID;
		 this.dname=dname;
		 this.dept=dept;
		 this.pym=pym;
		 
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym;
	}

	
	 
	
}