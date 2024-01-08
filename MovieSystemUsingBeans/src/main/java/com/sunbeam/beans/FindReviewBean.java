package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;

public class FindReviewBean {

	private int reviewId;
	private ReviewPojo review;
	
	public FindReviewBean() {
		// TODO Auto-generated constructor stub
	}

	
	public ReviewPojo getReview() {
		return review;
	}


	public void setReview(ReviewPojo review) {
		this.review = review;
	}


	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	
	
	public void findReview()
	{
		try(ReviewDao rd = new ReviewDao())
		{
			this.review = rd.findById(reviewId);
			review.toString();
			if(review!=null)
				System.out.println("Review Found!!");
			else
				System.out.println("Not Found!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
