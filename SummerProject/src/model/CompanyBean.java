package model;  

import java.sql.Date;

/************

Author: Patricia Anne Eugenio

Description: Company Bean with their columns as their attribute and their getters and setters.
Date: 5/6/14
************/

public class CompanyBean {
	private int pIdCompany;
	private String pCompanyName;
	private int pZipCode;
	private String pContactNumber;
	private Date pRegistrationDate;
	private String companyStatus;
	private int pIdUser;
	private String pStreet;
	private String pCity;
	
	public int getpIdCompany() {
		return pIdCompany;
	}
	public void setpIdCompany(int pIdCompany) {
		this.pIdCompany = pIdCompany;
	}
	public String getpCompanyName() {
		return pCompanyName;
	}
	public void setpCompanyName(String pCompanyName) {
		this.pCompanyName = pCompanyName;
	}
	public int getpZipCode() {
		return pZipCode;
	}
	public void setpZipCode(int pZipCode) {
		this.pZipCode = pZipCode;
	}
	public String getpContactNumber() {
		return pContactNumber;
	}
	public void setpContactNumber(String pContactNumber) {
		this.pContactNumber = pContactNumber;
	}
	public Date getpRegistrationDate() {
		return pRegistrationDate;
	}
	public void setpRegistrationDate(Date pRegistrationDate) {
		this.pRegistrationDate = pRegistrationDate;
	}
	public String getCompanyStatus() {
		return companyStatus;
	}
	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}
	public int getpIdUser() {
		return pIdUser;
	}
	public void setpIdUser(int pIdUser) {
		this.pIdUser = pIdUser;
	}
	public String getpStreet() {
		return pStreet;
	}
	public void setpStreet(String pStreet) {
		this.pStreet = pStreet;
	}
	public String getpCity() {
		return pCity;
	}
	public void setpCity(String pCity) {
		this.pCity = pCity;
	}
}
