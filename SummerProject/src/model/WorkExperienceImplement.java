/************

Author: Patricia Anne Eugenio

Description: Work Experience related queries and it can be accessed through its methods
Date: 5/9/14
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkExperienceImplement {
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private AgentBean pAgentBean;
	private JobOpeningBean pJobOpeningBean;
	private WorkExperienceBean pWorkExperienceBean;
	
	public WorkExperienceImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
	}
	
	public void insertWorkExperience(WorkExperienceBean workExperienceBean, JobOpeningBean jobOpeningBean, AgentBean agentBean)
	{
		pWorkExperienceBean = workExperienceBean;
		pJobOpeningBean = jobOpeningBean;
		pAgentBean = agentBean;
		
		String query = "INSERT IGNORE into workexperience(startingDate, yearEffective, agentSalary, idJobOpening, idAgent) VALUES(?,?,?,?,?)";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setDate(1, pWorkExperienceBean.getpStartingDate());
			pStatement.setInt(2, pWorkExperienceBean.getpYearsEffective());
			pStatement.setFloat(3, pWorkExperienceBean.getpAgentSalary());
			pStatement.setInt(4, pJobOpeningBean.getpIdJobOpening());
			pStatement.setInt(5, pAgentBean.getpIdAgent());
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
