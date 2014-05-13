/************

Author: Patricia Anne Eugenio

Description: Rating related queries and it can be accessed through its methods
Date: 5/9/14
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingImplement implements RatingInterface 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private RatingBean pRatingBean;
	private WorkExperienceBean pWorkExperienceBean;
	
	public RatingImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;	
	}
	
	public void insertRating(RatingBean ratingBean, WorkExperienceBean workExperience)
	{
		pRatingBean = ratingBean;
		pWorkExperienceBean = workExperience;
		
		String query = "INSERT IGNORE into rating (rating, idWorkExperience) VALUES(?,?)";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setFloat(1, pRatingBean.getpRating());
			pStatement.setInt(2, pWorkExperienceBean.getpIdWorkExperienceBean());
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
