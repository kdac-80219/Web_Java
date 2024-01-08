package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojo.ReviewPojo;

public class ReviewDao extends Dao implements ReviewInterfaceDao {


	public ReviewDao() throws SQLException {
	
	}

	public int save(ReviewPojo r) throws Exception {
		String sql = "INSERT INTO reviews(id, movie_id, review, rating, user_id, modified_date) VALUES(default, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
	
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			stmt.setDate(5,java.sql.Date.valueOf(r.getModified()));
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();		
	}
	
	public int update(ReviewPojo r) throws Exception {
		String sql = "UPDATE reviews SET movie_id=?, review=?, rating=?, user_id=?, modified_date=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			stmt.setDate(5,java.sql.Date.valueOf(r.getModified()));
			stmt.setInt(6, r.getId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();		
	}

	public List<ReviewPojo> findAll() throws Exception {
		List<ReviewPojo> list = new ArrayList<ReviewPojo>();
		String sql = "SELECT * FROM reviews";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int userId = rs.getInt("user_id");
					String modifiedDate = rs.getString("modified_date");
					ReviewPojo r = new ReviewPojo(id, movieId,review,rating, userId, modifiedDate);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
	
	public List<ReviewPojo> findByUserId(int userId) throws Exception {
		List<ReviewPojo> list = new ArrayList<ReviewPojo>();
		String sql = "SELECT * FROM reviews WHERE user_id=? ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modifiedDate = rs.getString("modified_date");
					ReviewPojo r = new ReviewPojo(id, movieId,review, usrId, rating, modifiedDate);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}
	
	public List<ReviewPojo> getSharedWithUser(int userId) throws Exception {
		List<ReviewPojo> list = new ArrayList<ReviewPojo>();
		String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modifiedDate = rs.getString("modified_date");
					ReviewPojo r = new ReviewPojo(id, movieId,review, usrId, rating, modifiedDate);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	public ReviewPojo findById(int id) throws Exception {
		String sql = "SELECT * FROM reviews WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modifiedDate = rs.getString("modified_date");
					ReviewPojo r = new ReviewPojo(id, movieId,review, usrId, rating, modifiedDate);
					return r;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public int shareReview(int reviewId, int userId) throws Exception {
		String sql = "INSERT INTO shares(review_id, user_id) VALUES (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		}
		catch (SQLIntegrityConstraintViolationException e) {
			// do nothing
		}
		return 0;
	}

	@Override
	public int save(ReviewDao r) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReviewDao r) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
