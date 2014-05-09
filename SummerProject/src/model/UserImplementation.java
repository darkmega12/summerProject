package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import view.Driver;

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
	private ArrayList<UserBean> pUserList;
	private Connection pConnect;
	private ResultSet pResult;
	private PreparedStatement pPreparedstmt;
	private Statement pStatement;
	
	
	public UserImplementation()
	{
		pConnect=null;
		pUserBean= new UserBean();
		pUserList= new ArrayList<UserBean>();
		pResult= null;
		pStatement=null;
	}
	
	
	/******
	 * Function Name: getAllUsers
	 * Description: stores all users from the databases in pUserBean
	******/
	
	public void getAllUsers()
	{
		try
		{
			pConnect= Driver.dbConnect.connectToDatabase();
			pStatement= pConnect.createStatement();
			pResult= pStatement.executeQuery("Select * from User");
			while(pResult.next())
			{
				pUserBean.setpIdUser(pResult.getInt("idUser"));
				pUserBean.setpUserName(pResult.getString("userName"));
				pUserBean.setpUserPassword(pResult.getString("userPassword"));
				pUserBean.setpUserType(pResult.getString("userType"));
				pUserList.add(pUserBean);
			}
			Driver.dbConnect.closeConnection(pConnect, pStatement);
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
		try
		{
			pConnect= Driver.dbConnect.connectToDatabase();
			String query="INSERT INTO user (userName, userPassword, userType) Values (?, ?, ?)";
			pPreparedstmt= pConnect.prepareStatement(query);
			pPreparedstmt.setString(1, newUser.getpUserName());
			pPreparedstmt.setString(2, newUser.getpUserPassword());
			pPreparedstmt.setString(3, newUser.getpUserType());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		Driver.dbConnect.closeConnection(pConnect, pStatement);
		pUserList.add(newUser);
	}
	
	
	/******
	 * Function Name: getUser
	 * Description: Returns a user bean that matches the username and password with the parameter uBean.
	 * 				If there was no match found, the function returns the parameter
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
		return uBean;
	}
}
