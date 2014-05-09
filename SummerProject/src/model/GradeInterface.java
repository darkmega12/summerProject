/************

Author: Patricia Anne Eugenio

Description: Interface of the Grade related queries implemented by GradeImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface GradeInterface 
{
	// methods to be called for add, view all, update, view specific grade
	public void insertGrade(AgentBean agentBean, ClassBean classBean, GradeBean gradeBean);
	public boolean updateGrade(GradeBean newGradeBean, GradeBean oldGradeBean);
	public int searchGradeId(ClassBean classBean, AgentBean agentBean);
	public ArrayList<GradeBean> getAllGrades();
	public ArrayList<GradeBean> searchGradesByAgent(AgentBean agentBean);
	public ArrayList<GradeBean> searchGradesByClass(ClassBean classBean);
}
