package model; 

import java.sql.Date;

/************

Author: Patricia Anne Eugenio

Description: Class Bean with their columns as their attribute and their getters and setters.
Date: 5/6/14
************/

public class ClassBean {
	private int pIdClass;
	private int pAgentCount;
	private Date pStartingDate;
	private Date pEndingDate;
	private String pSchedule;
	private String pVenue;
	private String pClassStatus;
	private int pIdCourse;
	private int pIdAgent;
	private int pIdGrade;
	
	public int getpIdClass() {
		return pIdClass;
	}
	public void setpIdClass(int pIdClass) {
		this.pIdClass = pIdClass;
	}
	public int getpAgentCount() {
		return pAgentCount;
	}
	public void setpAgentCount(int pAgentCount) {
		this.pAgentCount = pAgentCount;
	}
	public Date getpStartingDate() {
		return pStartingDate;
	}
	public void setpStartingDate(Date pStartingDate) {
		this.pStartingDate = pStartingDate;
	}
	public Date getpEndingDate() {
		return pEndingDate;
	}
	public void setpEndingDate(Date pEndingDate) {
		this.pEndingDate = pEndingDate;
	}
	public String getpSchedule() {
		return pSchedule;
	}
	public void setpSchedule(String pSchedule) {
		this.pSchedule = pSchedule;
	}
	public String getpVenue() {
		return pVenue;
	}
	public void setpVenue(String pVenue) {
		this.pVenue = pVenue;
	}
	public String getpClassStatus() {
		return pClassStatus;
	}
	public void setpClassStatus(String pClassStatus) {
		this.pClassStatus = pClassStatus;
	}
	public int getpIdCourse() {
		return pIdCourse;
	}
	public void setpIdCourse(int pIdCourse) {
		this.pIdCourse = pIdCourse;
	}
	public int getpIdAgent() {
		return pIdAgent;
	}
	public void setpIdAgent(int pIdAgent) {
		this.pIdAgent = pIdAgent;
	}
	public int getpIdGrade() {
		return pIdGrade;
	}
	public void setpIdGrade(int pIdGrade) {
		this.pIdGrade = pIdGrade;
	}	
}
