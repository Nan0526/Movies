package com.movie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CinemasBO {
	private Connection ct = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public ArrayList<Cinemas> getCinemas() {
		ArrayList<Cinemas> al=new ArrayList<Cinemas>();
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			
			String sql="select * from Cinemas ";
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				//userbean
				Cinemas gBean=new Cinemas();
				gBean.setId(rs.getInt(1));
				gBean.setCity(rs.getString(2));
				gBean.setName(rs.getString(3));
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
