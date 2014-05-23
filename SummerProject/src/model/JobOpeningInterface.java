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
	public int searchJobOpeningId(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByRequestDate(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByDueDate(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByCompleteDate(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByOpeningStatus(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByGender(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByQuantity(JobOpeningBean jobOpeningBean);
	public ArrayList<JobOpeningBean> searchGradesByCompany(CompanyBean companyBean);
	public int getIdJobOpening(CompanyBean companyBean);
}
