/************

Author: Patricia Anne Eugenio

Description: Class related scripts and it is accessible through its methods
Date: 5/8/2014
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassImplement {
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CourseBean pCourseBean;
	private ClassBean pClassBean;
	
	public ClassImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
		pCourseBean = new CourseBean();
		pClassBean = new ClassBean();
	}
	
	public void insertClass(CourseBean courseBean, ClassBean classBean)
	{
		pClassBean = classBean;
		pCourseBean = courseBean;
		
		String query = "INSERT IGNORE into class (agentCount, startingDate, endingDate, schedule, venue, classStatus, idCourse) VALUES(?,?,?,?,?,?,?)";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pClassBean.getpAgentCount());
			pStatement.setDate(2, pClassBean.getpStartingDate());
			pStatement.setDate(3, pClassBean.getpEndingDate());
			pStatement.setString(4, pClassBean.getpSchedule());
			pStatement.setString(5, pClassBean.getpVenue());
			pStatement.setString(6, pClassBean.getpClassStatus());
			pStatement.setInt(7, pCourseBean.getpIdCourse());
			pStatement.executeUpdate();
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
