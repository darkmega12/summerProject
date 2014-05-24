/************

Author: Patricia Anne Eugenio

Description: Interface of the Education Background (Agent) related queries implemented by EducationBGImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface EducationBGInterface 
{
	// methods to be called for add, view all, update, view specific education background
	public void insertEducationBG(AgentBean agentBean, EducationBGBean educationBG);
	public boolean updateEducationBG(EducationBGBean newEducationBGBean, EducationBGBean oldEducationBGBean);
	public ArrayList<EducationBGBean> getAllEducationBG();
	public ArrayList<EducationBGBean> searchEducationBGByAgent(AgentBean agentBean); // get education by agent name
	public ArrayList<EducationBGBean> searchEducationBGByEducationBG(EducationBGBean educationBGBean); // get education by educationBG details 
}
