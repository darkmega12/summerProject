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
	private ListCoursesBean pListCoursesBean;
	
	public ListCoursesImplement()
	{
		pStatement  = null;
		pResult = null;
		pDatabase = new DatabaseConnector();
		pAgentBean = null;
		pCourseBean = null;
		pListCoursesBean = null;
		pConnection = null;	
	}
	
	public void insertListCourses(AgentBean agentBean, CourseBean courseBean)
	{
		pConnection = pDatabase.connectToDatabase();
		
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
	
	/************
	 * Disclaimer: It only changes the idCourse. Thus, all other ids are assumed to be on the oldBean.
	 * idCourse is the only field editable. 
	 ************/
	@Override
	public boolean updateListCourses(ListCoursesBean newListCoursesBean, ListCoursesBean oldListCoursesBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pListCoursesBean = newListCoursesBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE listcourses set idCourse = ? "
				+ "WHERE idAgent = ? AND idListCourses = ?";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setInt(1, pListCoursesBean.getpIdCourse());
			pStatement.setInt(2, oldListCoursesBean.getpIdAgent());
			pStatement.setInt(3, oldListCoursesBean.getpIdListCourses());
			
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
	public ArrayList<CourseBean> searchListCoursesByAgent(AgentBean agentBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pAgentBean = agentBean;
		
		ArrayList<CourseBean> arrCourse = new ArrayList<CourseBean>();
		
		String query = "SELECT course.courseCode FROM course INNER JOIN listcourses ON listcourses.idAgent = ? and listcourses.idCourse=course.idCourse;";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pAgentBean.getpIdAgent());
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				CourseBean courseBean = new CourseBean();
				
				courseBean.setpCourseCode(pResult.getString("courseCode"));
				
				arrCourse.add(courseBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrCourse;
	}
}
