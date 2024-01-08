package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;

public class ReviewListBean {
	
	private List<ReviewPojo>reviewList;
	private List <MoviePojo>movieList;

	 

	public List<MoviePojo> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MoviePojo> movieList) {
		this.movieList = movieList;
	}

	public ReviewListBean() {
		
		reviewList = new ArrayList<ReviewPojo>();
		movieList = new ArrayList<MoviePojo>();
	}
	
	public List<ReviewPojo> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<ReviewPojo> reviewList) {
		this.reviewList = reviewList;
	}
	
	public void Listreview()
	{
		try(ReviewDao rd = new ReviewDao())
		{
			reviewList = rd.findAll();
			try(MovieDao movieDao=new MovieDao())
			{
				movieList=movieDao.findAll();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
