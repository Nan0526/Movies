package com.movie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoviesBO {
	private Connection ct = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public Map<String,ArrayList<Movies>> getHomePage() {
		Map<String,ArrayList<Movies>> map=new HashMap<>();
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ArrayList<Movies> al_showing=new ArrayList<Movies>();
			String showing_sql="select * from movie where "
					+ "state='showing' order by id desc limit 0,3";
			ps=ct.prepareStatement(showing_sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Movies gBean=new Movies();
				gBean.setId(rs.getInt(1));
				gBean.setName(rs.getString(2));
				gBean.setPrice(rs.getFloat(3));
				gBean.setDirector(rs.getString(4));
				gBean.setArtists(rs.getString(5));
				gBean.setLeading(rs.getString(6));
				gBean.setIntro(rs.getString(7));
				gBean.setImg(rs.getString(8));
				gBean.setState(rs.getString(9));
				gBean.setDates(rs.getString(10));
				gBean.setType(rs.getString(11));
				al_showing.add(gBean);
			}
			map.put("showing", al_showing);
			//coming
			ArrayList<Movies> al_coming=new ArrayList<Movies>();
			showing_sql="select * from movie where "
					+ "state='coming' order by id desc limit 0,3";
			ps=ct.prepareStatement(showing_sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Movies gBean=new Movies();
				gBean.setId(rs.getInt(1));
				gBean.setName(rs.getString(2));
				gBean.setPrice(rs.getFloat(3));
				gBean.setDirector(rs.getString(4));
				gBean.setArtists(rs.getString(5));
				gBean.setLeading(rs.getString(6));
				gBean.setIntro(rs.getString(7));
				gBean.setImg(rs.getString(8));
				gBean.setState(rs.getString(9));
				gBean.setDates(rs.getString(10));
				gBean.setType(rs.getString(11));
				al_coming.add(gBean);
			}
			map.put("coming", al_coming);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return map;
	}
	public ArrayList<Movies> getMovieByState(String state) {
		ArrayList<Movies> al=new ArrayList<Movies>();
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			
			String sql="select * from movie where "
					+ "state='"+state+"' order by id desc";
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Movies gBean=new Movies();
				gBean.setId(rs.getInt(1));
				gBean.setName(rs.getString(2));
				gBean.setPrice(rs.getFloat(3));
				gBean.setDirector(rs.getString(4));
				gBean.setArtists(rs.getString(5));
				gBean.setLeading(rs.getString(6));
				gBean.setIntro(rs.getString(7));
				gBean.setImg(rs.getString(8));
				gBean.setState(rs.getString(9));
				gBean.setDates(rs.getString(10));
				gBean.setType(rs.getString(11));
				al.add(gBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	public Movies getMovies(String id) {
		Movies gBean=new Movies();
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			
			String showing_sql="select * from movie where id='"+id+"'";
			ps=ct.prepareStatement(showing_sql);
			rs=ps.executeQuery();
			if(rs.next()){
				gBean.setId(rs.getInt(1));
				gBean.setName(rs.getString(2));
				gBean.setPrice(rs.getFloat(3));
				gBean.setDirector(rs.getString(4));
				gBean.setArtists(rs.getString(5));
				gBean.setLeading(rs.getString(6));
				gBean.setIntro(rs.getString(7));
				gBean.setImg(rs.getString(8));
				gBean.setState(rs.getString(9));
				gBean.setDates(rs.getString(10));
				gBean.setType(rs.getString(11));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return gBean;
	}
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (ct != null) {
				ct.close();
				ct = null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
