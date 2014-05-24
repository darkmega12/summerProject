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
import java.util.ArrayList;

public class CompanyImplement implements CompanyInterface
{
	private DatabaseConnector pDatabase;
	private Connection pConnection;
	private PreparedStatement pStatement;
	private ResultSet pResult;
	private CompanyBean pCompanyBean;
	private UserBean pUserBean;
	
	public CompanyImplement()
	{
		pStatement  = null;
		pResult = null;
		pCompanyBean = null;
		pUserBean = null;
		pConnection = null;
		pDatabase = new DatabaseConnector();
	}
	
	public void insertCompany(CompanyBean companyBean, UserBean userBean)
	{
		pConnection = pDatabase.connectToDatabase();
		
		pCompanyBean = companyBean;
		pUserBean = userBean;
		
		String query = "INSERT IGNORE into company (companyName, zipCode, contactNumber, registrationDate, companyStatus, idUser, street, city) VALUES(?,?,?,?,?,?,?,?)";
		
		try 
		{
			pConnection = pDatabase.connectToDatabase();
			pStatement = pConnection.prepareStatement(query);
			pStatement.setString(1, pCompanyBean.getpCompanyName());
			pStatement.setInt(2, pCompanyBean.getpZipCode());
			pStatement.setString(3, pCompanyBean.getpContactNumber());
			pStatement.setDate(4, pCompanyBean.getpRegistrationDate());
			pStatement.setString(5, pCompanyBean.getpCompanyStatus());
			pStatement.setInt(6, pUserBean.getpIdUser());
			pStatement.setString(7, pCompanyBean.getpStreet());
			pStatement.setString(8, pCompanyBean.getpCity());
			pStatement.executeUpdate();
			pDatabase.closeConnection(pConnection, pStatement);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/************
	 * Disclaimer: It assumes the old ids are in oldBean instead of newBean since the ids can't be edited anyway.
	 * All fields are editable except for idCompany.
	 ************/
	@Override
	public boolean updateCompany(CompanyBean oldCompanyBean, CompanyBean newCompanyBean) 
	{
		pConnection = pDatabase.connectToDatabase();
		pCompanyBean = newCompanyBean;
		boolean isSuccessful = true;
		
		String query = "UPDATE company set companyName = ? "
				+ "zipCode = ?, contactNumber = ?, registrationDate = ?, "
				+ "companyStatus = ?, idUser = ?, street = ?, city = ? where idCompany = ?";
		
		try
		{
			pStatement = pConnection.prepareStatement(query);
			
			pStatement.setString(1, pCompanyBean.getpCompanyName());
			pStatement.setInt(2, pCompanyBean.getpZipCode());
			pStatement.setString(3, pCompanyBean.getpContactNumber());
			pStatement.setDate(4, pCompanyBean.getpRegistrationDate());
			pStatement.setString(5, pCompanyBean.getpCompanyStatus());
			pStatement.setInt(6, oldCompanyBean.getpIdUser());
			pStatement.setString(7, pCompanyBean.getpStreet());
			pStatement.setString(8, pCompanyBean.getpCity());
			pStatement.setInt(9, oldCompanyBean.getpIdCompany());
			
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
	public ArrayList<CompanyBean> getAllCompany() 
	{
		pConnection = pDatabase.connectToDatabase();
		ArrayList<CompanyBean> arrCompany = new ArrayList<CompanyBean>();
		
		String query = "SELECT * from company";
		
		try 
		{
			pStatement = pConnection.prepareStatement(query);
			pResult = pStatement.executeQuery();
			
			while(pResult.next())
			{
				CompanyBean companyBean = new CompanyBean();
				
				companyBean.setpIdCompany(pResult.getInt("idCompany"));
				companyBean.setpCompanyName(pResult.getString("companyName"));
				companyBean.setpZipCode(pResult.getInt("zipCode"));
				companyBean.setpContactNumber(pResult.getString("contactNumber"));
				companyBean.setpRegistrationDate(pResult.getDate("registrationDate"));
				companyBean.setpCompanyStatus(pResult.getString("companyStatus"));
				companyBean.setpIdUser(pResult.getInt("idUser"));
				companyBean.setpStreet(pResult.getString("street"));
				companyBean.setpCity(pResult.getString("city"));
				
				arrCompany.add(companyBean);
			}
			
			pDatabase.closeAllConnection(pConnection, pStatement, pResult);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrCompany;
	}
	
	public boolean searchDuplicate(CompanyBean companyBean)
	{
		pConnection = pDatabase.connectToDatabase();
		
		boolean duplicate= false;
		
		String query= "select companyName, contactNumber, zipCode " +
					  "from company " +
					  "where companyName= ? and contactNumber= ? and zipCode= ?";
		try
		{
			System.out.println(companyBean.getpCompanyName()+" "+companyBean.getpContactNumber()+" "+companyBean.getpZipCode());
			pStatement= pConnection.prepareStatement(query);
			pStatement.setString(1, companyBean.getpCompanyName());
			pStatement.setString(2, companyBean.getpContactNumber());
			pStatement.setInt(3, companyBean.getpZipCode());
			pStatement.executeQuery();
			if(pResult!=null)
				duplicate=true;
			pDatabase.closeConnection(pConnection, pStatement);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByCompany(CompanyBean companyBean)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByUser(UserBean userBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
