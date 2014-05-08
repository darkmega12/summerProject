package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles all queries regarding the User table in the database
 * 
*****/

public class UserImplementation 
{
	private UserBean pUserBean;
	private ArrayList<UserBean> pUserList= new ArrayList<UserBean>();
	private ResultSet pRset;
	private Statement pStatement;
	
	
	public UserImplementation(DatabaseConnector db)
	{
		try
		{
			pStatement=db.connectToDatabase().createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("SQL ERROR: "+ e.getMessage());
		}
	}
	
	
	/******
	 * Function Name: getAllUsers
	 * Description: stores all users from the databases in pUserBean
	******/
	
	public void getAllUsers()
	{
		try
		{
			pRset= pStatement.executeQuery("Select * from User");
			
			while(pRset.next())
			{
				pUserBean.setpIdUser(pRset.getInt("idUser"));
				pUserBean.setpUserName(pRset.getString("userName"));
				pUserBean.setpUserPassword(pRset.getString("userPassword"));
				pUserBean.setpUserType(pRset.getString("userType"));
				pUserList.add(pUserBean);
			}
			
		} 
		catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	/******
	 * Function Name: getUser
	 * Description: add
	******/
	
	public void addUser(UserBean newUser)
	{
		pUserList.add(newUser);
	}
	
	
	/******
	 * Function Name: getUser
	 * Description: returns a user bean that matches the username and password with the parameter uBean
	 * uBean- contains the username and password to verify
	******/
	
	public UserBean getUser(UserBean uBean)
	{
		Iterator<UserBean> i = pUserList.iterator();
		while(i.hasNext())
		{
			pUserBean= i.next();
			if(pUserBean.getpUserName().equals(uBean.getpUserName()) && pUserBean.getpUserPassword().equals(uBean.getpUserPassword()))
				return pUserBean;
		}
	}
}
