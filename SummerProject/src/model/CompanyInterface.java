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
	public int searchCompanyId(CompanyBean companyBean);
	public ArrayList<CompanyBean> searchCompanyByName(CompanyBean companyBean);
	public ArrayList<CompanyBean> searchCompanyByRegistrationDate(CompanyBean companyBean);
	public ArrayList<CompanyBean> searchCompanyByCompanyStatus(CompanyBean companyBean);
	public ArrayList<CompanyBean> searchCompanyByCity(CompanyBean companyBean);
}
