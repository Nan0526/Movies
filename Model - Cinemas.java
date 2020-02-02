package com.movie.model;

public class Cinemas {
	private int    id ;
	private String    city ;
	private String    name ;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Cinemas(){}
	public Cinemas(String city, String name) {
		this.city = city;
		this.name = name;
	}
	
	
	
	
}
