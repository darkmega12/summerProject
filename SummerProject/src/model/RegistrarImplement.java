/************

Author: Patricia Anne Eugenio

Description: Registrar related queries and it can be accessed through its methods
Date: 5/9/14
************/

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrarImplement 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private RegistrarBean pRegistrarBean;
	private UserBean pUserBean;
	
	public RegistrarImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;		
	}
	
	public void insertRegistrar(UserBean userBean, RegistrarBean registrarBean)
	{
		pRegistrarBean = registrarBean;
		pUserBean = userBean;
		
		String query = "INSERT IGNORE into registrar (lastName, firstName, middleName, idUser) VALUES(?,?,?,?)";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pRegistrarBean.getpLastName());
			pStatement.setString(2, pRegistrarBean.getpFirstName());
			pStatement.setString(3, pRegistrarBean.getpMiddleName());
			pStatement.setInt(4, pUserBean.getpIdUser());
			pStatement.executeUpdate();
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
