package com.movie.model;

import java.sql.*;
public class ConnDB {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/movies";
	private String username = "root";
	private String password = "root";
	private Connection ct = null;
	public Connection getConn() {
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	}

}
