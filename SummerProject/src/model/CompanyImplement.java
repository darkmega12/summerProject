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

	@Override
	public boolean updateCompany(CompanyBean oldCompanyBean, CompanyBean newCompanyBean) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CompanyBean> getAllCompany() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByName(CompanyBean companyBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchCompanyId(CompanyBean companyBean) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByRegistrationDate(CompanyBean companyBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByCompanyStatus(CompanyBean companyBean) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CompanyBean> searchCompanyByCity(CompanyBean companyBean)
	{
		// TODO Auto-generated method stub
		return null;
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
}
