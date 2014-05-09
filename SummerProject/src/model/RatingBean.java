package model; 
/************

Author: Patricia Anne Eugenio

Description: Rating Bean with their columns as their attribute and their getters and setters.
Date: 5/7/14
************/ 

public class RatingBean 
{
	private int pIdRating;
	private float pRating;
	private int pIdWorkExperience;
	
	public int getpIdRating() 
	{
		return pIdRating;
	}
	public void setpIdRating(int pIdRating) 
	{
		this.pIdRating = pIdRating;
	}
	public float getpRating() 
	{
		return pRating;
	}
	public void setpRating(float pRating) 
	{
		this.pRating = pRating;
	}
	public int getpIdWorkExperience() {
		return pIdWorkExperience;
	}
	public void setpIdWorkExperience(int pIdWorkExperience) {
		this.pIdWorkExperience = pIdWorkExperience;
	}
}
