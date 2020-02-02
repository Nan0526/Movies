package com.movie.model;

public class CinemaState {
	private int    id ;
	private int    cinemaId ;
	private int    movieId ;
	private String     dates;
	private String    times ;
	private String    seats ;
	
	public int getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}

	public CinemaState(int cinemaId, int movieId, String dates, String times, String seats) {
		super();
		this.cinemaId = cinemaId;
		this.movieId = movieId;
		this.dates = dates;
		this.times = times;
		this.seats = seats;
	}
	public CinemaState(){}
	
	
}
