package model; 
/************

Author: Patricia Anne Eugenio

Description: Grade Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/

public class GradeBean 
{
	private int pIdGrade;
	private int pIdClass;
	private float pGrade;
	private int pIdAgent;
	
	public int getpIdGrade() 
	{
		return pIdGrade;
	}
	public void setpIdGrade(int pIdGrade) 
	{
		this.pIdGrade = pIdGrade;
	}
	public float getpGrade() 
	{
		return pGrade;
	}
	public void setpGrade(float pGrade) 
	{
		this.pGrade = pGrade;
	}
	public int getpIdAgent() 
	{
		return pIdAgent;
	}
	public void setpIdAgent(int pIdAgent) 
	{
		this.pIdAgent = pIdAgent;
	}
	public int getpIdClass() {
		return pIdClass;
	}
	public void setpIdClass(int pIdClass) {
		this.pIdClass = pIdClass;
	}
}
