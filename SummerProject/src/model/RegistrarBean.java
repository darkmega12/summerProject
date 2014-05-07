package model; 
/************

Author: Patricia Anne Eugenio

Description: Registrar Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/ 

public class RegistrarBean {
	private int pIdRegistrar;
	private int pLastName;
	private int pFirstName;
	private int pMiddleName;
	private int pIdUser;
	
	public int getpIdRegistrar() {
		return pIdRegistrar;
	}
	public void setpIdRegistrar(int pIdRegistrar) {
		this.pIdRegistrar = pIdRegistrar;
	}
	public int getpLastName() {
		return pLastName;
	}
	public void setpLastName(int pLastName) {
		this.pLastName = pLastName;
	}
	public int getpFirstName() {
		return pFirstName;
	}
	public void setpFirstName(int pFirstName) {
		this.pFirstName = pFirstName;
	}
	public int getpMiddleName() {
		return pMiddleName;
	}
	public void setpMiddleName(int pMiddleName) {
		this.pMiddleName = pMiddleName;
	}
	public int getpIdUser() {
		return pIdUser;
	}
	public void setpIdUser(int pIdUser) {
		this.pIdUser = pIdUser;
	}
}
