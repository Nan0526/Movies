package com.movie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UsersBO {
	private Connection ct = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	public String updateUser(String username,  float newMoney) {	
		String b="false";
		try{	
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("update users set money='"+
					newMoney+"' where username='"+username+"'");
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
	public Users getUsers(String u) {
		Users bean = new Users();
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select  * from users where userName='"
					+ u + "' limit 0, 1");
			rs = ps.executeQuery();
			if (rs.next()) {
				bean.setUsername(rs.getString(1));
				bean.setPsw(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setNick(rs.getString(4));
				bean.setAge(rs.getInt(5));
				bean.setPhone(rs.getString(6));
				bean.setMoney(rs.getFloat(7));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return bean;
	}
	
	public boolean checkUser(String u, String p) {
		boolean b=false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select  psw from users where username='"
					+ u + "' limit 0, 1");
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbPasswd = rs.getString(1);
				if (dbPasswd.equals(p)) {
					b=true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	//true:false:exist
	public String addUser(String username, String psw, 
			String name, String nick, int age, 
			String phone) {
		String b="false";
		if(isExistUsers(username))return "exist";
		try{
			
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("insert into users "
					+ "(username, psw, name, nick, age, "
					+ "phone,  money) values(?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, psw);
			ps.setString(3, name);
			ps.setString(4, nick);
			ps.setInt(5, age);
			ps.setString(6, phone);
			ps.setFloat(7, 100.0f);
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

	private boolean isExistUsers(String username) {
		boolean b=false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select  psw from users where username='"
					+ username + "' limit 0, 1");
			rs = ps.executeQuery();
			if (rs.next()) {
				b=true;
			}
		} catch (Exception e) {
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
