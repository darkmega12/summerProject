/************

Author: Patricia Anne Eugenio

Description: Contains the Agent related scripts and accessible through the methods.
Date: 5/8/2014
************/
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgentImplement 
{
	private AgentBean pAgentBean;
	private UserBean pUserBean;
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	
	public AgentImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
		pAgentBean = new AgentBean();
		pUserBean = new UserBean();
	}
	
	public void insertAgent(AgentBean agentBean, UserBean userBean)
	{
		pAgentBean = agentBean;
		pUserBean = userBean;
		
		String query = "INSERT IGNORE into agent (lastName, firstName, middleName, landline, mobile, birthDate, gender, applicationDate, agentStatus, idUser, zipCode, street, city) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pAgentBean.getpLastName());
			pStatement.setString(2, pAgentBean.getpFirstName());
			pStatement.setString(3, pAgentBean.getpMiddleName());
			pStatement.setString(4, pAgentBean.getpLandline());
			pStatement.setString(5, pAgentBean.getpMobile());
			pStatement.setDate(6, pAgentBean.getpBirthDate());
			pStatement.setString(7, pAgentBean.getpGender());
			pStatement.setDate(8, pAgentBean.getpApplicationDate());
			pStatement.setString(9, pAgentBean.getpStatus());
			pStatement.setInt(10, pUserBean.getpIdUser());
			pStatement.setInt(11, pAgentBean.getpZipCode());
			pStatement.setString(12, pAgentBean.getpStreet());
			pStatement.setString(13, pAgentBean.getpCity());
			pStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				pStatement.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				pConnection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
