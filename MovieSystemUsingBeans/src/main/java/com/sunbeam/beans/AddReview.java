package com.sunbeam.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;

public class AddReview {

	private int movieId;
	private String review;
	private int rating;
	private int userId;
	private String modifiedDate;
	private List<MoviePojo>movielist;
	private ReviewPojo re=null;
	
	
	
	public ReviewPojo getRe() {
		return re;
	}

	public void setRe(ReviewPojo re) {
		this.re = re;
	}

	public AddReview() {
		movielist=new ArrayList<MoviePojo>();
		
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
	
	public List<MoviePojo> getMovielist() {
		return movielist;
	}

	public void setMovielist(List<MoviePojo> movielist) {
		this.movielist = movielist;
	}

	public void addReview()
	{
		try(ReviewDao rdao = new ReviewDao())
		{
			
			ReviewPojo rp = new ReviewPojo(movieId, review, rating, userId, modifiedDate);
			System.out.println("Inside addreview");																						
			int cnt = rdao.save(rp);
			this.re = rp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try(MovieDao mdao = new MovieDao())
		{
			movielist = mdao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
