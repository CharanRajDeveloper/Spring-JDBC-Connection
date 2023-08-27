package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class JDBCConnection {
	private String username;
	private String password;
	private String url;
	private String Driver;

	public String getUsername() {
		return username;
	}

	@Required
	@Value("${mysql.username}")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@Required
	@Value("${mysql.password}")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	@Required
	@Value("${mysql.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return Driver;
	}

	@Value("${mysql.Driver}")
	public void setDriver(String driver) {
		Driver = driver;
	}

	public void getJDBCConnection() throws ClassNotFoundException, SQLException {

		Class.forName(Driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement ps = con.prepareStatement("select * from charan.developerdata");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "::" + rs.getString(1) + "::" + rs.getString(2));
		}

		System.out.println("username:" + username);
		System.out.println("Password:" + password);
		System.out.println("URL:" + url);
		System.out.println("Driver:" + Driver);
	}
}
