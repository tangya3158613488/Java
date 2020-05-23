package com.Mywork.model;

import java.util.Date;

public class Report {
	private String dorId;
	private String equipId;
	private String equipName;
	private Date reportDate;
	private String reportReason;
	
	public Report(){}

	public Report(String dorId, String equipId, String equipName, Date reportDate, String reportReason) {
		this.dorId = dorId;
		this.equipId = equipId;
		this.equipName = equipName;
		this.reportDate = reportDate;
		this.reportReason = reportReason;
	}

	public String getDorId() {
		return dorId;
	}

	public void setDorId(String dorId) {
		this.dorId = dorId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	
}
