/************

Author: Patricia Anne Eugenio

Description: List of Courses related queries and it can be accessed through its methods
Date: 5/9/14
************/

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListCoursesImplement implements ListCoursesInterface{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CourseBean pCourseBean;
	private AgentBean pAgentBean;
	
	public ListCoursesImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;	
	}
	
	public void insertListCourses(AgentBean agentBean, CourseBean courseBean)
	{
		pAgentBean = agentBean;
		pCourseBean = courseBean;
		
		String query = "INSERT IGNORE into listcourses (idCourse, idAgent) VALUES(?,?)";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pCourseBean.getpIdCourse());
			pStatement.setInt(2, pAgentBean.getpIdAgent());
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
	public boolean updateListCourses(ListCoursesBean newListCoursesBean, ListCoursesBean oldListCoursesBean) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CourseBean> getAllListCoursesByAgent(AgentBean agentBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
