/************

Author: Patricia Anne Eugenio

Description: Grade related queries and it can be accessed through its methods
Date: 5/9/14
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeImplement implements GradeInterface
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private AgentBean pAgentBean;
	private ClassBean pClassBean;
	private GradeBean pGradeBean;
	
	public GradeImplement()
	{
		pStatement  = null;
		pResult = null;
		pDatabase = new DatabaseConnector();
		pAgentBean = null;
		pClassBean = null;
		pGradeBean = null;
		pConnection = null;
	}	
	
	public void insertGrade(AgentBean agentBean, ClassBean classBean, GradeBean gradeBean)
	{
		pConnection = pDatabase.connectToDatabase();
		
		pAgentBean = agentBean;
		pClassBean = classBean;
		pGradeBean = gradeBean;
		
		String query = "INSERT IGNORE into grade (grade, idClass, idAgent) VALUES(?,?,?)";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setFloat(1, pGradeBean.getpGrade());
			pStatement.setInt(2, pClassBean.getpIdClass());
			pStatement.setInt(3, pAgentBean.getpIdAgent());
			pStatement.executeUpdate();
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/************
	 * Disclaimer: Only grade is being changed depending on the idClass, idGrade, idAgent combination. 
	 * Thus, all ids should be on the oldGradeBean.
	 ************/
	@Override
	public boolean updateGrade(GradeBean newGradeBean, GradeBean oldGradeBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pGradeBean = newGradeBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE grade set grade = ? "
				+ "where idAgent = ? and idClass = ? and idGrade = ?";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setFloat(1, pGradeBean.getpGrade());
			pStatement.setInt(2, oldGradeBean.getpIdAgent());
			pStatement.setInt(3, oldGradeBean.getpIdClass());
			pStatement.setInt(4, oldGradeBean.getpIdGrade());
			
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
	public int searchGradeId(ClassBean classBean, AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<GradeBean> getAllGrades() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<GradeBean> arrGrade = new ArrayList<GradeBean>();
		
		String query = "SELECT * from grade";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				GradeBean gradeBean = new GradeBean();
				
				gradeBean.setpIdGrade(pResult.getInt("idGrade"));
				gradeBean.setpGrade(pResult.getFloat("grade"));
				gradeBean.setpIdClass(pResult.getInt("idClass"));
				gradeBean.setpIdAgent(pResult.getInt("idAgent"));
				
				arrGrade.add(gradeBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrGrade;
	}

	@Override
	public ArrayList<GradeBean> searchGradesByAgent(AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GradeBean> searchGradesByClass(ClassBean classBean)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
