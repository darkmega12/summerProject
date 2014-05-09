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

public class GradeImplement 
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
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
	}	
	
	public void insertGrade(AgentBean agentBean, ClassBean classBean, GradeBean gradeBean)
	{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
