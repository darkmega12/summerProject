package model; 
/************

Author: Patricia Anne Eugenio

Description: Registrar Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/ 

public class RegistrarBean 
{
	private int pIdRegistrar;
	private String pLastName;
	private String pFirstName;
	private String pMiddleName;
	private int pIdUser;
	
	public int getpIdRegistrar() 
	{
		return pIdRegistrar;
	}
	public void setpIdRegistrar(int pIdRegistrar) 
	{
		this.pIdRegistrar = pIdRegistrar;
	}
	public String getpLastName() 
	{
		return pLastName;
	}
	public void setpLastName(String pLastName) 
	{
		this.pLastName = pLastName;
	}
	public String getpFirstName() 
	{
		return pFirstName;
	}
	public void setpFirstName(String pFirstName) 
	{
		this.pFirstName = pFirstName;
	}
	public String getpMiddleName()
	{
		return pMiddleName;
	}
	public void setpMiddleName(String pMiddleName) 
	{
		this.pMiddleName = pMiddleName;
	}
	public int getpIdUser() 
	{
		return pIdUser;
	}
	public void setpIdUser(int pIdUser) 
	{
		this.pIdUser = pIdUser;
	}
}
