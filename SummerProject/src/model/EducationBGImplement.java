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
		pStatement  = null;
		pResult = null;
		pAgentBean = null;
		pEducationBG = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertEducationBG(AgentBean agentBean, EducationBGBean educationBG)
	{
		pConnection = pDatabase.connectToDatabase();
		
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
			e.printStackTrace();
		}
	}

	/************
	 * Disclaimer: It assumes the old ids are in oldBean instead of newBean since the ids can't be edited anyway
	 * All fields are editable except for idEducationBG.
	 ************/
	@Override
	public boolean updateEducationBG(EducationBGBean oldEducationBGBean, EducationBGBean newEducationBGBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pEducationBG = newEducationBGBean;
		boolean isSuccessful = true; 
		
		String query = "UPDATE educationbg set degree = ?, yearCompletion = ?, "
				+ "university = ?, idAgent = ? where idEducationBG = ?";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setString(1, pEducationBG.getpDegree());
			pStatement.setInt(2, pEducationBG.getpYear());
			pStatement.setString(3, pEducationBG.getpUniversity());
			pStatement.setInt(4, pEducationBG.getpIdAgent());
			pStatement.setInt(5, pEducationBG.getpIdEducationBG());
			
			pStatement.executeUpdate();
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch (SQLException e) 
		{
			isSuccessful = false;
			e.printStackTrace();
		}
		
		return isSuccessful;
	}

	@Override
	public ArrayList<EducationBGBean> getAllEducationBG() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<EducationBGBean> arrEduc = new ArrayList<EducationBGBean>();
		
		String query = "SELECT * from educationbg";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				EducationBGBean educationBGBean = new EducationBGBean();
				
				educationBGBean.setpIdEducationBG(pResult.getInt("idEducationBG"));
				educationBGBean.setpDegree(pResult.getString("degree"));
				educationBGBean.setpYear(pResult.getInt("yearCompletion"));
				educationBGBean.setpUniversity(pResult.getString("university"));
				educationBGBean.setpIdAgent(pResult.getInt("idAgent"));
				
				arrEduc.add(educationBGBean);
			}
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrEduc;
	}
	@Override
	
	public ArrayList<EducationBGBean> searchEducationBGByEducationBG(EducationBGBean educationBGBean) 
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
