package model; 
/************

Author: Patricia Anne Eugenio

Description: EducationBG Bean with their columns as their attribute and their getters and setters.
Date: 5/6/14
************/ 
public class EducationBGBean {
	private int pIdEducationBG;
	private String pDegree;
	private int pYear;
	private String pUniversity;
	private int pIdAgent;
	
	public int getpIdEducationBG() {
		return pIdEducationBG;
	}
	public void setpIdEducationBG(int pIdEducationBG) {
		this.pIdEducationBG = pIdEducationBG;
	}
	public String getpDegree() {
		return pDegree;
	}
	public void setpDegree(String pDegree) {
		this.pDegree = pDegree;
	}
	public int getpYear() {
		return pYear;
	}
	public void setpYear(int pYear) {
		this.pYear = pYear;
	}
	public String getpUniversity() {
		return pUniversity;
	}
	public void setpUniversity(String pUniversity) {
		this.pUniversity = pUniversity;
	}
	public int getpIdAgent() {
		return pIdAgent;
	}
	public void setpIdAgent(int pIdAgent) {
		this.pIdAgent = pIdAgent;
	}

}
