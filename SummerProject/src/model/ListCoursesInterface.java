/************

Author: Patricia Anne Eugenio

Description: Interface of the ListCourses related queries implemented by ListCoursesImplement
Date: 5/13/2014
************/

package model;

import java.util.ArrayList;

public interface ListCoursesInterface {
	public void insertListCourses(AgentBean agentBean, CourseBean courseBean);
	public boolean updateListCourses(ListCoursesBean newListCoursesBean, ListCoursesBean oldListCoursesBean);
	public ArrayList<CourseBean> getAllListCoursesByAgent(AgentBean agentBean);
}
