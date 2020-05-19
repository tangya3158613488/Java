package com.Demo1.model;

import java.util.Date;

public class Chufang {
	private int ID;
	private String chufangID;
	private int doctorId;
	private Date chufangDate;
	private float money;
	private int isVerify;
	
	public Chufang() {}
	 
	 public Chufang(int ID,String chufangID, int doctorId,Date chufangDate, float money, int isVerify) {
		 this.ID=ID;
		 this.chufangID=chufangID;
		 this.doctorId=doctorId;
		 this.chufangDate=chufangDate;
		 this.money = money;
		 this.isVerify = isVerify;
		 
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getChufangID() {
		return chufangID;
	}

	public void setChufangID(String chufangID) {
		this.chufangID = chufangID;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getChufangDate() {
		return chufangDate;
	}

	public void setChufangDate(Date chufangDate) {
		this.chufangDate = chufangDate;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public int getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(int isVerify) {
		this.isVerify = isVerify;
	}
	 
}
