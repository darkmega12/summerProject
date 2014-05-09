/************

Author: Patricia Anne Eugenio

Description: Interface of Class related queries implemented by ClassImplement
Date: 5/9/2014
************/
package model;

import java.util.ArrayList;

public interface ClassInterface 
{
	// methods to be called for add, view all, update, view specific class
	public void insertClass(CourseBean courseBean, ClassBean classBean);
	public boolean updateClass(ClassBean newClassBean, ClassBean oldClassBean);
	public ArrayList<ClassBean> getAllClass();
	public ArrayList<ClassBean> searchClassByCourseCode(CourseBean courseBean);
	public ArrayList<ClassBean> searchClassByStartDate(ClassBean classBean);
	public ArrayList<ClassBean> searchClassByEndDate(ClassBean classBean);
	public ArrayList<ClassBean> searchClassByClassStatus(ClassBean classBean);
	public ArrayList<ClassBean> searchClassByClassVenue(ClassBean classBean);
	public ArrayList<ClassBean> searchClassByClassSchedule(ClassBean classBean);
}
