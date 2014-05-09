/************
Author: Patricia Anne Eugenio

Description: It will connect the program to the database.
Date: 5/7/2014 
************/
package model;

import java.sql.*;
/* import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;*/

public class DatabaseConnector 
{
	private String user;
	private String pass;
	private String URL;
	
	public DatabaseConnector()
	{
		user = "root";
		pass = "dlsu";
		URL= "jdbc:mysql://localhost:3306/ecall";
	}
	
	public Connection connectToDatabase() 
	{
		  Connection conn = null;
		  try 
		  {
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(URL, user, pass);
		      System.out.println("Connected!");
		  }
		  catch(Exception e) 
		  {
		    System.out.println(e.getMessage());
		  }
		  return conn;
	}
	
	public void closeConnection(Connection conn, Statement stmt)
	{
		try
		{
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeConnection(Connection conn, PreparedStatement stmt)
	{
		try
		{
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
