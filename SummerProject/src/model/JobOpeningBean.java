package model; 

import java.sql.Date;

/************

Author: Patricia Anne Eugenio

Description: Job Opening Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/

public class JobOpeningBean {
	private int pIdJobOpening;
	private Date pRequestDate;
	private Date pDueDate;
	private Date pCompleteDate;
	private String pOpeningStatus;
	private String pGender;
	private int pQuantity;
	private int pIdCompany;
	
	public int getpIdJobOpening() {
		return pIdJobOpening;
	}
	public void setpIdJobOpening(int pIdJobOpening) {
		this.pIdJobOpening = pIdJobOpening;
	}
	public Date getpRequestDate() {
		return pRequestDate;
	}
	public void setpRequestDate(Date pRequestDate) {
		this.pRequestDate = pRequestDate;
	}
	public Date getpDueDate() {
		return pDueDate;
	}
	public void setpDueDate(Date pDueDate) {
		this.pDueDate = pDueDate;
	}
	public Date getpCompleteDate() {
		return pCompleteDate;
	}
	public void setpCompleteDate(Date pCompleteDate) {
		this.pCompleteDate = pCompleteDate;
	}
	public String getpOpeningStatus() {
		return pOpeningStatus;
	}
	public void setpOpeningStatus(String pOpeningStatus) {
		this.pOpeningStatus = pOpeningStatus;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public int getpIdCompany() {
		return pIdCompany;
	}
	public void setpIdCompany(int pIdCompany) {
		this.pIdCompany = pIdCompany;
	}
}
