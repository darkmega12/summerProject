/************

Author: Patricia Anne Eugenio

Description: Interface of the WorkExperience related queries implemented by WorkExperienceImplement
Date: 5/13/2014
************/
package model;

import java.util.ArrayList;

public interface WorkExperienceInterface 
{
	public void insertWorkExperience(WorkExperienceBean workExperienceBean, JobOpeningBean jobOpeningBean, AgentBean agentBean);
	public boolean updateWorkExperience(WorkExperienceBean newWorkExperienceBean, WorkExperienceBean oldWorkExperienceBean);
	public WorkExperienceBean searchWorkExperienceBean(JobOpeningBean jobOpeningBean, AgentBean agentBean);
	public ArrayList<WorkExperienceBean> getWorkExperienceBeanByJobOpening(JobOpeningBean jobOpeningBean);
	public ArrayList<WorkExperienceBean> getWorkExperienceBeanByAgent(AgentBean agentBean);
}
