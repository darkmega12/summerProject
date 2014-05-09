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
import java.util.ArrayList;

public class EducationBGImplement implements EducationBGInterface
{
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
	public boolean updateEducationBG(EducationBGBean oldEducationBGBean, EducationBGBean newEducationBGBean) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<EducationBGBean> getAllEducationBG() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EducationBGBean> searchEducationBGByAgent(AgentBean agentBean)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
