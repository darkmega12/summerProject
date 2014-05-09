/************

Author: Patricia Anne Eugenio

Description: Rating related queries and it can be accessed through its methods
Date: 5/9/14
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingImplement 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private RatingBean pRatingBean;
	
	public RatingImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;	
	}
	
	public void insertRating(RatingBean ratingBean)
	{
		pRatingBean = ratingBean;
		
		String query = "INSERT IGNORE into rating (rating) VALUES(?)";
	}
}
