/************

Author: Patricia Anne Eugenio

Description: Course Bean with their columns as their attribute and their getters and setters.
Date: 5/6/14
************/

public class CourseBean {
	private int pIdCourse;
	private String pCourseDescription;
	private String pCourseCode;
	private String pCourseName;
	private int pHourCount;
	private int pIdAgent;
	
	public int getpIdCourse() {
		return pIdCourse;
	}
	public void setpIdCourse(int pIdCourse) {
		this.pIdCourse = pIdCourse;
	}
	public String getpCourseDescription() {
		return pCourseDescription;
	}
	public void setpCourseDescription(String pCourseDescription) {
		this.pCourseDescription = pCourseDescription;
	}
	public String getpCourseCode() {
		return pCourseCode;
	}
	public void setpCourseCode(String pCourseCode) {
		this.pCourseCode = pCourseCode;
	}
	public String getpCourseName() {
		return pCourseName;
	}
	public void setpCourseName(String pCourseName) {
		this.pCourseName = pCourseName;
	}
	public int getpHourCount() {
		return pHourCount;
	}
	public void setpHourCount(int pHourCount) {
		this.pHourCount = pHourCount;
	}
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
}
