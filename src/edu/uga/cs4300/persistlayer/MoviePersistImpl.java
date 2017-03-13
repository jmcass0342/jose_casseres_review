package edu.uga.cs4300.persistlayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uga.cs4300.persistlayer.DbAccessInterface;

public class MoviePersistImpl {
	DbAccessInterface database = new DbAccessImpl();
	Connection con = null;
	public MoviePersistImpl(){
		
		try {
			con = database.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		database.disconnect(con);
	}
	
	public int insertMovie(String name, int year, double rank){
		String insert = "insert into movies ( name, year, rank ) values ( '" + name + "', " + year + ", " + rank + " )";   
		return database.create(con, insert);
	}
	
	public int insertReview(int movie_id, String review){
		String insert = "insert into movies ( movie_id, review ) values ( " + movie_id + ", '" + review + "' )";   
		return database.create(con, insert);
	}
	
	public ResultSet selectMovie(){
		String select = "select id, name, year, rank from movies";
		return database.retrieve(con, select);
	}
	
	public ResultSet selectReview(){
		String select = "select id, movie_id, review from reviews";
		return database.retrieve(con, select);
	}
	
	public ResultSet selectReviewByMovie(int movie_id){
		String select = "select review from reviews where movie_id = " + movie_id;
		return database.retrieve(con, select);	
	}
	
	public int deleteMovie(int id){
		String delete = "delete from movies where id = " + id;
		return database.delete(con, delete);
	}
	
	public int deleteReview(int id){
		String delete = "delete from reviews where id = " + id;
		return database.delete(con, delete);
	}
	
	public int updateMovie(String name, int year, double rank,int id){
		StringBuilder update = new StringBuilder();
		update.append("update movies set name = '" + name+ "', year = "+ year+ ", rank = " + rank + "where id = " + id );
		return database.update(con, update.toString());
	}
	
	public int updateReview(int movie_id, String review, int id){
		StringBuilder update = new StringBuilder();
		update.append("update reviews set review = '" + review + "', movie_id = "+ movie_id  + "where id = " + id );
		return database.update(con, update.toString());
	}
	
}
