/************

Author: Patricia Anne Eugenio

Description: Interface of the Job Opening related queries implemented by JobOpeningImplement
Date: 5/10/2014
************/
package model;

import java.util.ArrayList;

public interface JobOpeningInterface 
{
	// methods to be called for add, view all, update, view specific job opening
	public void insertJobOpening(CompanyBean companyBean, JobOpeningBean jobOpeningBean);
	public boolean updateJobOpening(JobOpeningBean oldJobOpeningBean, JobOpeningBean newJobOpeningBean);
	public ArrayList<JobOpeningBean> getAllJobOpening();
	public ArrayList<JobOpeningBean> searchJobOpeningByJobOpening(JobOpeningBean jobOpeningBean); // get job opening by job opening details
	public ArrayList<JobOpeningBean> searchGradesByCompany(CompanyBean companyBean); // get job opening by company name 
}
