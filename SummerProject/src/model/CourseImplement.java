/************

Author: Patricia Anne Eugenio

Description: Course related methods with the need of queries.
Date: 5/9/2014 
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseImplement implements CourseInterface
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CourseBean pCourseBean;
	
	public CourseImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;	
	}
	
	public void insertCourse(CourseBean courseBean)
	{
		pCourseBean = courseBean;
		String query = "INSERT IGNORE into course (courseDescription, courseCode, courseName, hourCount) VALUES(?,?,?,?)";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pCourseBean.getpCourseDescription());
			pStatement.setString(2, pCourseBean.getpCourseCode());
			pStatement.setString(3, pCourseBean.getpCourseName());
			pStatement.setInt(4, pCourseBean.getpHourCount());
			pStatement.executeUpdate();
			pDatabase.closeConnection(pConnection, pStatement);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateCourse(CourseBean newCourseBean, CourseBean oldCourseBean)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CourseBean> getAllCourse() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CourseBean> searchCourseByCourseCode(CourseBean courseBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
