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
import java.util.ArrayList;

public class AgentImplement implements AgentInterface 
{
	private AgentBean pAgentBean;
	private UserBean pUserBean;
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	
	public AgentImplement()
	{
		pStatement  = null;
		pResult = null;
		pDatabase = null;
		pAgentBean = null;
		pUserBean = null;
		pConnection = null;
	}
	
	public void insertAgent(AgentBean agentBean, UserBean userBean)
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		
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
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateAgent(AgentBean newAgentBean, AgentBean oldAgentBean) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<AgentBean> getAllAgents() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AgentBean> searchAgentByName(AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AgentBean> searchAgentByApplicationDate(AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AgentBean> searchAgentByApplicationStatus(AgentBean agentBean)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AgentBean> searchAgentByCity(AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchAgentId(AgentBean agentBean)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
