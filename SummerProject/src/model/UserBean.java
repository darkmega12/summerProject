package model; 
/************

Author: Patricia Anne Eugenio

Description: User Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/



public class UserBean 
{
	private int pIdUser;
	private String pUserName;
	private String pUserPassword;
	private String pUserType;
	
	public UserBean()
	{
		pIdUser=0;
		pUserName=null;
		pUserPassword=null;
		pUserType=null;
	}
	
	public int getpIdUser() 
	{
		return pIdUser;
	}
	public void setpIdUser(int pIdUser) 
	{
		this.pIdUser = pIdUser;
	}
	public String getpUserName() 
	{
		return pUserName;
	}
	public void setpUserName(String pUserName) 
	{
		this.pUserName = pUserName;
	}
	public String getpUserPassword() 
	{
		return pUserPassword;
	}
	public void setpUserPassword(String pUserPassword) 
	{
		this.pUserPassword = pUserPassword;
	}
	public String getpUserType() 
	{
		return pUserType;
	}
	public void setpUserType(String pUserType) 
	{
		this.pUserType = pUserType;
	}
}
