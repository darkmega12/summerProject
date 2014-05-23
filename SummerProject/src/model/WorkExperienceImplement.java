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
import java.util.ArrayList;

public class WorkExperienceImplement implements WorkExperienceInterface 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private AgentBean pAgentBean;
	private JobOpeningBean pJobOpeningBean;
	private WorkExperienceBean pWorkExperienceBean;
	
	public WorkExperienceImplement()
	{
		pStatement  = null;
		pResult = null;
		pDatabase = new DatabaseConnector();
		pAgentBean = null;
		pJobOpeningBean = null;
		pWorkExperienceBean = null;
		pConnection = null;
	}
	
	public void insertWorkExperience(WorkExperienceBean workExperienceBean, JobOpeningBean jobOpeningBean, AgentBean agentBean)
	{
		pConnection = pDatabase.connectToDatabase(); 
		
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

	/************
	 * Disclaimer: All fields are editable except for idAgent, idJobOpening and idWorkExperience 
	 * Thus, all ids should be on the oldWorkExperienceBean.
	 ************/
	@Override
	public boolean updateWorkExperience(WorkExperienceBean newWorkExperienceBean, WorkExperienceBean oldWorkExperienceBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pWorkExperienceBean = newWorkExperienceBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE workexperience set startingDate = ? "
				+ "yearEffective = ?, agentSalary  = ? "
				+ "where  idJobOpening = ? and idAgent = ? and idWorkExperience = ?"; 
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setDate(1, pWorkExperienceBean.getpStartingDate());
			pStatement.setInt(2, pWorkExperienceBean.getpYearsEffective());
			pStatement.setFloat(3, pWorkExperienceBean.getpAgentSalary());
			pStatement.setInt(4, oldWorkExperienceBean.getpIdJobOpening());
			pStatement.setInt(5, oldWorkExperienceBean.getpIdAgent());
			pStatement.setInt(6, oldWorkExperienceBean.getpIdWorkExperienceBean());
			
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
	public WorkExperienceBean searchWorkExperienceBean(JobOpeningBean jobOpeningBean, AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WorkExperienceBean> getWorkExperienceBeanByJobOpening(JobOpeningBean jobOpeningBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pJobOpeningBean = jobOpeningBean;
		
		ArrayList<WorkExperienceBean> arrWorkBean = new ArrayList<WorkExperienceBean>();
		
		String query = "SELECT workexperience.startingDate, workexperience.yearEffective, workexperience.agentSalary FROM workexperience INNER JOIN jobOpening ON workexperience.idJobOpening = jobopening.idJobOpening and jobopening.idJobOpening = ?";
		
		try {
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pJobOpeningBean.getpIdJobOpening());
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				WorkExperienceBean workExperienceBean = new WorkExperienceBean();
				
				workExperienceBean.setpStartingDate(pResult.getDate("startingDate"));
				workExperienceBean.setpYearsEffective(pResult.getInt("yearEffective"));
				workExperienceBean.setpAgentSalary(pResult.getFloat("agentSalary"));
				
				arrWorkBean.add(workExperienceBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrWorkBean;
	}

	@Override
	public ArrayList<WorkExperienceBean> getWorkExperienceBeanByAgent(AgentBean agentBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pAgentBean = agentBean;
		ArrayList<WorkExperienceBean> arrWorkBean = new ArrayList<WorkExperienceBean>();
		
		String query = "SELECT workexperience.startingDate, workexperience.yearEffective, workexperience.agentSalary FROM workexperience INNER JOIN agent ON agent.idAgent = workexperience.idAgent and agent.idAgent = ?";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pAgentBean.getpIdAgent());
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				WorkExperienceBean workExperienceBean = new WorkExperienceBean();
				
				workExperienceBean.setpStartingDate(pResult.getDate("startingDate"));
				workExperienceBean.setpYearsEffective(pResult.getInt("yearEffective"));
				workExperienceBean.setpAgentSalary(pResult.getFloat("agentSalary"));
				
				arrWorkBean.add(workExperienceBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrWorkBean;
	}
}
