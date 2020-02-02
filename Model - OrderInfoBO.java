package com.movie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class OrderInfoBO {
	private Connection ct = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public CinemaState getOrderState(String cinemaId, String movieId,
			String dates, String times) {
		CinemaState bean = null;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select  * from cinemastate where cinemaId='"+
			cinemaId+"' and movieId='"+movieId+"' and dates='"+dates+"' and times='"+
					times+"'");
			rs = ps.executeQuery();
			if (rs.next()) {
				bean=new CinemaState();
				bean.setId(rs.getInt(1));
				bean.setCinemaId(rs.getInt(2));
				bean.setMovieId(rs.getInt(3));
				bean.setDates(rs.getString(4));
				bean.setTimes(rs.getString(5));
				bean.setSeats(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return bean;
	}

	public String addCinemaState(int cinemaId, int movieId,
			String dates, String times, String seats) {	
		String b="false";
		try{
			
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("insert into "
					+ "cinemastate (cinemaId, movieId, "
					+ "dates, times, seats) VALUES (?, ?, ?, ?,?)");
			ps.setInt(1, cinemaId);
			ps.setInt(2, movieId);
			ps.setString(3, dates);
			ps.setString(4, times);
			ps.setString(5, seats);
			int a = ps.executeUpdate();
			b="true";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	public String updateCinemaState(int id,  String seats) {	
		String b="false";
		try{	
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("update cinemastate set seats='"+
			seats+"' where id='"+id+"'");
			int a = ps.executeUpdate();
			b="true";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	public String addOrder(int cinemaId,
			int movieId,String dates,String times,
			String username,String orderTime,
			String seats,float prices) {	
		String b="false";
		try{
			
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("insert into "
					+ "orderinfo (cinemaId, movieId, "
					+ "dates, times, username, orderTime, "
					+ "seats, prices) VALUES (?, ?, ?, ?, "
					+ "?, ?, ?, ?)");
			ps.setInt(1, cinemaId);
			ps.setInt(2, movieId);
			ps.setString(3, dates);
			ps.setString(4, times);
			ps.setString(5, username);
			ps.setString(6, orderTime);
			ps.setString(7, seats);
			ps.setFloat(8, prices);
			int a = ps.executeUpdate();
			b="true";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
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
