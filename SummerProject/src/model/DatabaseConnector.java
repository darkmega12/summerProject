/*
 * Author: Patricia Anne Eugenio
 * Description: It will connect the program to the database. 
 */
package model;

import java.sql.*;
/* import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;*/

public class DatabaseConnector 
{
	public Connection connectToDatabase() 
	{
		  Connection conn = null;
		  String user = "root";
		  String pass = "dlsu";
		  String URL= "jdbc:mysql://localhost:3306/ecall";
		  try 
		  {
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(URL, user, pass);
		  }
		  catch(Exception e) 
		  {
		    System.out.println(e.getMessage());
		  }
		  return conn;
	}
}
