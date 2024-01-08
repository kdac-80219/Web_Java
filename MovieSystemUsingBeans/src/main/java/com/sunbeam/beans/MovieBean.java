package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.pojo.MoviePojo;

public class MovieBean {
	private List <MoviePojo> movieList;

	public List<MoviePojo> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MoviePojo> movieList) {
		this.movieList = movieList;
	}
	
	
	public void FindAll()
	{
		try(MovieDao movieDao=new MovieDao())
		{
			movieList=movieDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
