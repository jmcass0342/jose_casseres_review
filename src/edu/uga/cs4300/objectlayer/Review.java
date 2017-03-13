package edu.uga.cs4300.objectlayer;

public class Review {
	
	private int id;
	private int movie_id;
	private String review;
	
	public Review() {
		this.id = new Integer(null);
		this.movie_id = new Integer(null);
		this.review = null;
	}
	
	public Review(int id, int movie_id, String review) {
		this.id = id;
		this.movie_id = movie_id;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
