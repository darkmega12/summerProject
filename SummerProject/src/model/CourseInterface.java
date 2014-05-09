/************

Author: Patricia Anne Eugenio

Description: Interface of the Course related queries implemented by CourseImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface CourseInterface 
{
	// methods to be called for add, view all, update, view specific course
	public void insertCourse(CourseBean courseBean);
	public boolean updateCourse(CourseBean newCourseBean, CourseBean oldCourseBean);
	public ArrayList<CourseBean> getAllCourse();
	public int searchCourseId(CourseBean courseBean);
	public ArrayList<CourseBean> searchCourseByCourseCode(CourseBean courseBean);
	public ArrayList<CourseBean> searchCourseByCourseName(CourseBean courseBean);
}
