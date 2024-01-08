package com.sunbeam.pojo;


public class ReviewPojo {
	int id;
	int movieId;
	String review;
	int rating;
	int userId;
	String modifiedDate;
	
	
	public ReviewPojo()
	{
		this.id=0;
		this.modifiedDate="";
		this.movieId=0;
		this.rating=0;
		this.userId=0;
		this.review="";
	}
	
	public ReviewPojo(int id, int moiveId, String review, int rating, int userId, String modifiedDate) {
		this.id = id;
		this.movieId = moiveId;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.modifiedDate = modifiedDate;
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


	public String getModified() {
		return modifiedDate;
	}


	public void setModified(String modified) {
		this.modifiedDate = modified;
	}

	@Override
	public String toString() {
		return "ReviewPojo [id=" + id + ", movieId=" + movieId + ", review=" + review + ", rating=" + rating
				+ ", userId=" + userId + ", modified=" + modifiedDate + "]";
	}

	public String getDate(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
