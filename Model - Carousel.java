package com.movie.model;

public class Carousel {
	private int    movieId ;
	private String    img ;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Carousel(int movieId, String img) {
		super();
		this.movieId = movieId;
		this.img = img;
	}
	public Carousel(){}
	
}
