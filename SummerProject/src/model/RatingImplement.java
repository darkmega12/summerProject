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
import java.util.ArrayList;

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
		pStatement  = null;
		pResult = null;
		pRatingBean = null;
		pWorkExperienceBean = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertRating(RatingBean ratingBean, WorkExperienceBean workExperience)
	{
		pConnection = pDatabase.connectToDatabase();
		
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

	/************
	 * Disclaimer: It only changes the rating. Thus, all other ids are assumed to be on the oldBean.
	 * Rating is the only field editable. 
	 ************/
	@Override
	public boolean updateRating(RatingBean newRatingBean, RatingBean oldRatingBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pRatingBean = newRatingBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE rating set rating = ? "
				+ "WHERE idRating = ? AND idWorkExperience = ?";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setFloat(1, pRatingBean.getpRating());
			pStatement.setInt(2, oldRatingBean.getpIdRating());
			pStatement.setInt(3, oldRatingBean.getpIdWorkExperience());
			
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
	public ArrayList<RatingBean> getAllRatingByWorkExperience(WorkExperienceBean workExperienceBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pWorkExperienceBean = workExperienceBean;
		
		ArrayList<RatingBean> arrRating = new ArrayList<RatingBean>();
		
		String query = "SELECT rating.rating FROM workexperience INNER JOIN rating ON rating.idWorkExperience = workexperience.idWorkExperience and workexperience.idWorkExperience = ?";
		try {
			pStatement = pConnection.prepareStatement(query);
			pStatement.setInt(1, pWorkExperienceBean.getpIdWorkExperienceBean());
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				RatingBean ratingBean = new RatingBean();
				
				ratingBean.setpRating(pResult.getFloat("rating"));
				
				arrRating.add(ratingBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrRating;
	}
}
