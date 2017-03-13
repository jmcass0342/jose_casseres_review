package edu.uga.cs4300.logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import edu.uga.cs4300.persistlayer.MoviePersistImpl;

public class MovieLogicImpl {
	MoviePersistImpl persistence = null;
	public MovieLogicImpl(){
		persistence = new MoviePersistImpl();
	}
	
	
	public List<Movie> getMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		try {
			ResultSet rs = persistence.selectMovie();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int year = rs.getInt(3);
				double rank = rs.getDouble(4);
				Movie movie = new Movie(id,name,year,rank);
				movies.add(movie);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public List<Review> getReviews(){
		List<Review> reviews = new ArrayList<Review>();
		try {
			ResultSet rs = persistence.selectMovie();
			while(rs.next()){
				int id = rs.getInt(1);
				int movie_id = rs.getInt(2);
				String review = rs.getString(3);
				Review critique = new Review(id,movie_id,review);
				reviews.add(critique);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
	
	public List<Review> getReviewsByMovie(int movie_id){
		List<Review> reviews = new ArrayList<Review>();
		try {
			ResultSet rs = persistence.selectReviewByMovie(movie_id);
			while(rs.next()){
				int id = rs.getInt(1);
				int movieid = rs.getInt(2);
				String review = rs.getString(3);
				Review critique = new Review(id,movieid,review);
				reviews.add(critique);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
	public int insertMovie(String name, int year, double rank){
		return persistence.insertMovie(name, year, rank);
	}
	public int insertReview(String review, int movie_id){
		return persistence.insertReview(movie_id, review);
	}
	public int deleteMovie(int id){
		return persistence.deleteMovie(id);
	}
	public int deleteReview(int id){
		return persistence.deleteReview(id);
	}
	
	public int updateMovie(String name, int year, double rank,int id){
		return persistence.updateMovie(name, year, rank, id);
	}

	public int updateReview(int movie_id, String review,int id){
		return persistence.updateReview(movie_id, review, id);
	}
	public void disconnect(){
		persistence.disconnect();
	}
}
