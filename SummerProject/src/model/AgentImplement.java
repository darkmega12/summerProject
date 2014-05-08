/*
 * Author: Patricia Anne Eugenio
 * Description: Contains the Agent related scripts and accessible through their methods.
 */
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
	
	public void AgentImplement (AgentBean agent, UserBean user)
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
		
		String query = "INSERT IGNORE into athlete (lastName, firstName, middleInitial, landline, mobile, birthDate, gender, applicationDate, agentStatus, idUser, zipCode, street, city) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, agent.getpLastName());
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
