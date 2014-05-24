/************

Author: Patricia Anne Eugenio

Description: Interface of the Company related queries implemented by CompanyImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface CompanyInterface 
{
	// methods to be called for add, view all, update, view specific company
	public void insertCompany(CompanyBean companyBean, UserBean userBean);
	public boolean updateCompany(CompanyBean newCompanyBean, CompanyBean oldCompanyBean);
	public ArrayList<CompanyBean> getAllCompany();
	public ArrayList<CompanyBean> searchCompanyByCompany(CompanyBean companyBean); // get company by company details
	public ArrayList<CompanyBean> searchCompanyByUser(UserBean userBean); // get company by username
}
