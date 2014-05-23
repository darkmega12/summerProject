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
		pAgentBean = null;
		pUserBean = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertAgent(AgentBean agentBean, UserBean userBean)
	{
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

	/************
	 * Disclaimer: It assumes the old ids are in oldBean instead of newBean since the ids can't be edited anyway
	 * All fields are editable except for idAgent.
	 ************/
	@Override
	public boolean updateAgent(AgentBean newAgentBean, AgentBean oldAgentBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pAgentBean = newAgentBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE agent set lastName = ?, firstName = ?, middleName = ?, landline = ?, mobile = ?, birthDate = ?, gender = ?, applicationDate = ?, agentStatus = ?, idUser = ? , zipCode = ?, street = ?, city = ? where idAgent = ?"; 
		
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
			pStatement.setInt(10, oldAgentBean.getpIdUser());
			pStatement.setInt(11, pAgentBean.getpZipCode());
			pStatement.setString(12, pAgentBean.getpStreet());
			pStatement.setString(13, pAgentBean.getpCity());
			pStatement.setInt(14, oldAgentBean.getpIdAgent());
			
			pStatement.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			isSuccessful = false;
		}		
		pDatabase.closeConnection(pConnection, pStatement);
		return isSuccessful;
	}

	@Override
	public ArrayList<AgentBean> getAllAgents() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<AgentBean> arrAgent = new ArrayList<AgentBean>();
		
		String query = "SELECT * from agent";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				AgentBean agentBean = new AgentBean();
				
				agentBean.setpIdAgent(pResult.getInt("idAgent"));
				agentBean.setpLastName(pResult.getString("lastName"));
				agentBean.setpFirstName(pResult.getString("firstName"));
				agentBean.setpMiddleName(pResult.getString("middleName"));
				agentBean.setpLandline(pResult.getString("landline"));
				agentBean.setpMobile(pResult.getString("mobile"));
				agentBean.setpBirthDate(pResult.getDate("birthDate"));
				agentBean.setpGender(pResult.getString("gender"));
				agentBean.setpApplicationDate(pResult.getDate("applicationDate"));
				agentBean.setpStatus(pResult.getString("agentStatus"));
				agentBean.setpIdUser(pResult.getInt("idUser"));
				agentBean.setpZipCode(pResult.getInt("zipCode"));
				agentBean.setpStreet(pResult.getString("street"));
				agentBean.setpCity(pResult.getString("city"));
				
				arrAgent.add(agentBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		} 
		catch (SQLException e) 
		{
		
		}
		return arrAgent;
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
