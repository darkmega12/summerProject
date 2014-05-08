// This class sets the connection to the database
// This class simply loads the queries from the text file "INTRODB-queryScript.txt"
// ResultSet = table 

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
		  String pass = "root";
		  String URL= "jdbc:mysql://localhost:3306/Ecall";
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
