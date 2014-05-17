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
		pStatement  = null;
		pResult = null;
		pCourseBean = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertCourse(CourseBean courseBean)
	{
		pConnection = pDatabase.connectToDatabase();
		
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
	
	/************
	 * Disclaimer: It assumes the old ids are in oldBean instead of newBean since the ids can't be edited anyway
	 ************/
	@Override
	public boolean updateCourse(CourseBean newCourseBean, CourseBean oldCourseBean)
	{
		pConnection = pDatabase.connectToDatabase();
		pCourseBean = newCourseBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE course set courseDescription = ?, courseCode = ?, courseName = ?, hourCount = ? "
				+ "where idCourse = ?";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setString(1, pCourseBean.getpCourseDescription());
			pStatement.setString(2, pCourseBean.getpCourseCode());
			pStatement.setString(3, pCourseBean.getpCourseName());
			pStatement.setInt(4, pCourseBean.getpHourCount());
			pStatement.setInt(5, oldCourseBean.getpIdCourse());
			
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
	public ArrayList<CourseBean> getAllCourse() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<CourseBean> arrCourse = new ArrayList<CourseBean>();

		String query = "SELECT * from course";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				CourseBean courseBean = new CourseBean();
				
				courseBean.setpIdCourse(pResult.getInt("idCourse"));
				courseBean.setpCourseDescription(pResult.getString("courseDescription"));
				courseBean.setpCourseCode(pResult.getString("courseCode"));
				courseBean.setpCourseName(pResult.getString("courseName"));
				courseBean.setpHourCount(pResult.getInt("hourCount"));
				
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

	@Override
	public ArrayList<CourseBean> searchCourseByCourseCode(CourseBean courseBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchCourseId(CourseBean courseBean) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CourseBean> searchCourseByCourseName(CourseBean courseBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
