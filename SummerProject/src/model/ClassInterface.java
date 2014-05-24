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
	public ArrayList<ClassBean> getAllClass(); // gets all classes
	public ArrayList<ClassBean> searchClassByCourse(CourseBean courseBean); // gets all class by course details
	public ArrayList<ClassBean> searchClassByClass(ClassBean classBean); // gets all class by class details
}
