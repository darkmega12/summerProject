package model; 
/************

Author: Patricia Anne Eugenio

Description: List of Courses Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/

public class ListCoursesBean {
	private int pIdListCourses;
	private int pIdAgent;
	private int pIdCourse;
	
	public int getpIdListCourses() {
		return pIdListCourses;
	}
	public void setpIdListCourses(int pIdListCourses) {
		this.pIdListCourses = pIdListCourses;
	}
	public int getpIdAgent() {
		return pIdAgent;
	}
	public void setpIdAgent(int pIdAgent) {
		this.pIdAgent = pIdAgent;
	}
	public int getpIdCourse() {
		return pIdCourse;
	}
	public void setpIdCourse(int pIdCourse) {
		this.pIdCourse = pIdCourse;
	}
	
}
