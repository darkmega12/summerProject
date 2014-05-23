/************

Author: Patricia Anne Eugenio

Description: Registrar related queries and it can be accessed through its methods
Date: 5/9/14
************/

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrarImplement implements RegistrarInterface
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pPreparedStmt;
	private Statement pStatement;
	private ResultSet pResult;
	private RegistrarBean pRegistrarBean;
	private UserBean pUserBean;
	
	public RegistrarImplement()
	{
		pStatement  = null;
		pResult = null;
		pDatabase = new DatabaseConnector();
		pRegistrarBean = null;
		pPreparedStmt = null;
		pUserBean = null;
		pConnection = null;	
	}
	
	public void insertRegistrar(UserBean userBean, RegistrarBean registrarBean)
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		
		pRegistrarBean = registrarBean;
		pUserBean = userBean;
		
		String query = "INSERT IGNORE into registrar (lastName, firstName, middleName, idUser) VALUES(?,?,?,?)";
		try 
		{
			pPreparedStmt = pConnection.prepareStatement(query);
			pPreparedStmt.setString(1, pRegistrarBean.getpLastName());
			pPreparedStmt.setString(2, pRegistrarBean.getpFirstName());
			pPreparedStmt.setString(3, pRegistrarBean.getpMiddleName());
			pPreparedStmt.setInt(4, pUserBean.getpIdUser());
			pPreparedStmt.executeUpdate();
			pDatabase.closeConnection(pConnection, pPreparedStmt);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<UserBean> getAllUsers()
	{
		pConnection = pDatabase.connectToDatabase();
		
		ArrayList<UserBean> tempList= new ArrayList<UserBean>();
		try
		{
			pConnection= pDatabase.connectToDatabase();
			pStatement= pConnection.createStatement();
			pResult= pStatement.executeQuery("Select * from User");
			while(pResult.next())
			{
				pRegistrarBean.setpIdRegistrar(pResult.getInt("idRegistrar"));
				pRegistrarBean.setpFirstName(pResult.getString("firstName"));
				pRegistrarBean.setpMiddleName(pResult.getString("middleName"));
				pRegistrarBean.setpLastName(pResult.getString("lastName"));
				pRegistrarBean.setpIdUser(pResult.getInt("idUser"));
				tempList.add(pUserBean);
			}
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch(SQLException e)
		{
			System.err.println(e);
		}
		
		return tempList;
	}
	
	public boolean searchDuplicate(RegistrarBean registrarBean)
	{
		pConnection = pDatabase.connectToDatabase();
		boolean duplicate= false;
		
		String query= "select lastName, firstName, middleName " +
					  "from registrar " +
					  "where lastName= ? and firstName= ? and middleName= ?";
		try
		{
			System.out.println(registrarBean.getpFirstName()+" "+registrarBean.getpMiddleName()+" "+registrarBean.getpLastName());
			pPreparedStmt = pConnection.prepareStatement(query);
			pPreparedStmt.setString(1, registrarBean.getpLastName());
			pPreparedStmt.setString(2, registrarBean.getpFirstName());
			pPreparedStmt.setString(3, registrarBean.getpMiddleName());
			pResult= pPreparedStmt.executeQuery();
			if(pResult.next())
				duplicate=true;
			pDatabase.closeConnection(pConnection, pPreparedStmt);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean updateRegistrar(RegistrarBean newRegistrarBean, RegistrarBean oldRegistrarBean) 
	{
		return false;
	}

	@Override
	public int searchIdUserByName(RegistrarBean registrarBean) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchIdRegistrarByName(RegistrarBean registrarBean) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
