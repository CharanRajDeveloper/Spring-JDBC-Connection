package com.jdbc;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionData {
   public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("JDBCBean.xml");
	JDBCConnection con=context.getBean("jdbcConnection",JDBCConnection.class);
	try {
		con.getJDBCConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
