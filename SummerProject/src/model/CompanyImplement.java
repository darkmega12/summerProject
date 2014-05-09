/************
 
Author: Patricia Anne Eugenio

Description: Contains company related queries and accessible through its methods.
Date: 5/9/2014
************/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyImplement 
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CompanyBean pCompanyBean;
	private UserBean pUserBean;
	
	public CompanyImplement()
	{
		pDatabase = new DatabaseConnector();
		pConnection = pDatabase.connectToDatabase();
		pStatement  = null;
		pResult = null;
	}
	
	public void insertCompany(CompanyBean companyBean, UserBean userBean)
	{
		pCompanyBean = companyBean;
		pUserBean = userBean;
		
		String query = "INSERT IGNORE into company (companyName, zipCode, contactNumber, registrationDate, companyStatus, idUser, street, city) VALUES(?,?,?,?,?,?,?,?)";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pCompanyBean.getpCompanyName());
			pStatement.setInt(2, pCompanyBean.getpZipCode());
			pStatement.setString(3, pCompanyBean.getpContactNumber());
			pStatement.setDate(4, pCompanyBean.getpRegistrationDate());
			pStatement.setString(5, pCompanyBean.getCompanyStatus());
			pStatement.setInt(6, pUserBean.getpIdUser());
			pStatement.setString(7, pCompanyBean.getpStreet());
			pStatement.setString(8, pCompanyBean.getpCity());
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
