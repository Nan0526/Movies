package com.movie.model;

public class Movies {
	private int    id ;
	private String    name ;
	private float    price ;
	private String    director ;
	private String    artists ;
	private String    leading ;
	private String    intro ;
	private String    img ;
	private String    state ;
	private String    dates ;
	private String    type ;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getArtists() {
		return artists;
	}
	public void setArtists(String artists) {
		this.artists = artists;
	}
	public String getLeading() {
		return leading;
	}
	public void setLeading(String leading) {
		this.leading = leading;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Movies( String name, float price, String director, String artists, String leading, String intro,
			String img, String state, String dates, String type) {
		this.name = name;
		this.price = price;
		this.director = director;
		this.artists = artists;
		this.leading = leading;
		this.intro = intro;
		this.img = img;
		this.state = state;
		this.dates = dates;
		this.type = type;
	}
	public Movies(){}
	
}
