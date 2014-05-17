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
import java.util.ArrayList;

public class ClassImplement implements ClassInterface{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CourseBean pCourseBean;
	private ClassBean pClassBean;
	
	public ClassImplement()
	{
		pStatement  = null;
		pResult = null;
		pCourseBean = null;
		pClassBean = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertClass(CourseBean courseBean, ClassBean classBean)
	{
		pConnection = pDatabase.connectToDatabase();

		pClassBean = classBean;
		pCourseBean = courseBean;
		
		String query = "INSERT IGNORE into class (idCourse, agentCount, startingDate, endingDate, startTime, endTime, schedule, venue, classStatus) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pCourseBean.getpIdCourse());
			pStatement.setInt(2, pClassBean.getpAgentCount());
			pStatement.setDate(3, pClassBean.getpStartingDate());
			pStatement.setDate(4, pClassBean.getpEndingDate());
			pStatement.setString(5, pClassBean.getpStartTime());
			pStatement.setString(6, pClassBean.getpEndTime());
			pStatement.setString(7, pClassBean.getpSchedule());
			pStatement.setString(8, pClassBean.getpVenue());
			pStatement.setString(9, pClassBean.getpClassStatus());
			
			
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
	public boolean updateClass(ClassBean oldClassBean, ClassBean newClassBean) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ClassBean> getAllClass() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<ClassBean> arrClass = new ArrayList<ClassBean>();
		
		String query = "SELECT * from class";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while (pResult.next())
			{
				ClassBean classBean = new ClassBean();
				
				classBean.setpIdClass(pResult.getInt("idClass"));
				classBean.setpIdCourse(pResult.getInt("idCourse"));
				classBean.setpAgentCount(pResult.getInt("agentCount"));
				classBean.setpStartingDate(pResult.getDate("startingDate"));
				classBean.setpEndingDate(pResult.getDate("endingDate"));
				classBean.setpStartTime(pResult.getString("startTime"));
				classBean.setpEndTime(pResult.getString("endTime"));
				classBean.setpSchedule(pResult.getString("schedule"));
				classBean.setpVenue(pResult.getString("venue"));
				classBean.setpClassStatus(pResult.getString("classStatus"));
				
				arrClass.add(classBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrClass;
	}

	@Override
	public ArrayList<ClassBean> searchClassByCourseCode(CourseBean courseBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassBean> searchClassByStartDate(ClassBean classBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassBean> searchClassByEndDate(ClassBean classBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassBean> searchClassByClassStatus(ClassBean classBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassBean> searchClassByClassVenue(ClassBean classBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassBean> searchClassByClassSchedule(ClassBean classBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
