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
	private ArrayList<UserBean> pUserList;
	private ResultSet pRset;
	private Statement pStatement;
	
	
	public UserImplementation(DatabaseConnector db)
	{
		try
		{
			db.connectToDatabase().createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("SQL ERROR: "+ e.getMessage());
		}
	}
	
	public void searchUser(String user, String pass)
	{
		
	}
	
}
