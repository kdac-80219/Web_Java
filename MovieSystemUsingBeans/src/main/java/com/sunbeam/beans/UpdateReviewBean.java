package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;

public class UpdateReviewBean {
	
	private int id;
	private int movieId;
	private String review;
	private int rating;
	private int userId;
	private String modifiedDate;
	
	public UpdateReviewBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public void UpdateReview()
	{
		try(ReviewDao rd = new ReviewDao())
		{
			ReviewPojo rp = new ReviewPojo(movieId,id,review, userId,rating);
			int cnt = rd.update(rp);
			if(cnt!=0)
			{
				System.out.println("Review Updated!!!!");
			}
			else {
				System.out.println("Errrorrr");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
