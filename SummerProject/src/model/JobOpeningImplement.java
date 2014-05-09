/************

Author: Patricia Anne Eugenio

Description: Job Opening related queries and it can be accessed through its methods
Date: 5/9/14
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobOpeningImplement 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private JobOpeningBean pJobOpeningBean;
	private CompanyBean pCompanyBean;
	
	public JobOpeningImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;	
	}
	
	public void insertJobOpening(CompanyBean companyBean, JobOpeningBean jobOpeningBean)
	{
		pCompanyBean = companyBean;
		pJobOpeningBean = jobOpeningBean;
		
		String query = "INSERT IGNORE into jobopening (requestDate, dueDate, completeDate, openingStatus, gender, quantity, idCompany) VALUES(?,?,?,?,?,?,?)";
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setDate(1, pJobOpeningBean.getpRequestDate());
			pStatement.setDate(2, pJobOpeningBean.getpDueDate());
			pStatement.setDate(3, pJobOpeningBean.getpCompleteDate());
			pStatement.setString(4, pJobOpeningBean.getpOpeningStatus());
			pStatement.setString(5, pJobOpeningBean.getpGender());
			pStatement.setInt(6, pJobOpeningBean.getpQuantity());
			pStatement.setInt(7, pCompanyBean.getpIdCompany());
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
