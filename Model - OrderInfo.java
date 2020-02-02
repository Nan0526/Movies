package com.movie.model;

public class OrderInfo {
	private int    id ;
	private int    cinemaId ;
	private int    movieId ;
	private String     dates;
	private String    times ;
	private String    username ;
	private String    orderTime ;
	private String    seats ;
	private String    prices ;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	
	public OrderInfo(int cinemaId, int movieId, String dates, String times, String username, String orderTime,
			String seats, String prices) {
		super();
		this.cinemaId = cinemaId;
		this.movieId = movieId;
		this.dates = dates;
		this.times = times;
		this.username = username;
		this.orderTime = orderTime;
		this.seats = seats;
		this.prices = prices;
	}
	public OrderInfo(){}
	
	
}
