/************

Author: Patricia Anne Eugenio

Description: Interface of the Agent related queries implemented by AgentImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface AgentInterface 
{
	// methods to be called for add, view all, update, view specific agent
	public void insertAgent(AgentBean agentBean, UserBean userBean);
	public boolean updateAgent(AgentBean newAgentBean, AgentBean oldAgentBean);
	public int searchAgentId(AgentBean agentBean);
	public ArrayList<AgentBean> getAllAgents();
	public ArrayList<AgentBean> searchAgentByName(AgentBean agentBean);
	public ArrayList<AgentBean> searchAgentByApplicationDate(AgentBean agentBean);
	public ArrayList<AgentBean> searchAgentByApplicationStatus(AgentBean agentBean);
	public ArrayList<AgentBean> searchAgentByCity(AgentBean agentBean);
	public int getAgentID()
}
