package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;

public class ReviewDelete {

	private int id;
	private String message;
	
	public ReviewDelete() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void DeleteReview()
	{
		try(ReviewDao dao = new ReviewDao())
		{
			int cnt = dao.deleteById(id);
			this.message = "Review Deleted!!!";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
