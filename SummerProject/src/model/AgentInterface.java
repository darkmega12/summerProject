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
	public ArrayList<AgentBean> getAllAgents(); // gets all agents
	public ArrayList<AgentBean> searchAgentByAgent(AgentBean agentBean); // gets all agent by agent bean details
	public ArrayList<AgentBean> searchAgentByUser(UserBean userBean); // gets all applicants by username
}
