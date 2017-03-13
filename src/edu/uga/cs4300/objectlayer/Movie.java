package edu.uga.cs4300.objectlayer;

public class Movie {
	
	private int id;
	private String name;
	private int year;
	private double rank;
	
	public Movie() {
		this.id = new Integer(null);
		this.name = null;
		this.year = new Integer(null);
		this.rank = new Double(null);
	}
	
	
	public Movie(int id, String name, int year, double rank) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
}
