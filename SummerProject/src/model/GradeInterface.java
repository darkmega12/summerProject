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
	public ArrayList<GradeBean> getAllGrades();
	public ArrayList<GradeBean> searchGradesByAgent(AgentBean agentBean); // get grades by agent name
	public ArrayList<GradeBean> searchGradesByClass(ClassBean classBean); // get grades by class's course, starting date, ending date, start time, end time, schedule
}
