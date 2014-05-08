/************
 
Author: Patricia Anne Eugenio
 
Description: Education Background related queries and it is accessible through its methods.
Date: 5/9/2014
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationBGImplement {
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private AgentBean pAgentBean;
	private EducationBGBean pEducationBG;
	
	public EducationBGImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
	}
	
	public void insertEducationBG(AgentBean agentBean, EducationBGBean educationBG)
	{
		pEducationBG = educationBG;
		pAgentBean = agentBean;
		
		String query = "INSERT IGNORE into educationbg (degree, yearCompletion, university, idAgent) VALUES(?,?,?,?)";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pEducationBG.getpDegree());
			pStatement.setInt(2, pEducationBG.getpYear());
			pStatement.setString(3, pEducationBG.getpUniversity());
			pStatement.setInt(4, pAgentBean.getpIdAgent());
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
