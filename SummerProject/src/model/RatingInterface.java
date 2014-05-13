/************

Author: Patricia Anne Eugenio

Description: Interface of the Rating related queries implemented by RatingImplement
Date: 5/13/2014
************/

package model;

import java.util.ArrayList;

public interface RatingInterface
{
	public void insertRating(RatingBean ratingBean, WorkExperienceBean workExperience);
	public boolean updateRating(RatingBean newRatingBean, RatingBean oldRatingBean);
	public ArrayList<RatingBean> getAllRatingByWorkExperience(WorkExperienceBean workExperienceBean);
}
