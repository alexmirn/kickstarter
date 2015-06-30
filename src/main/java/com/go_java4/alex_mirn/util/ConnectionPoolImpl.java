package com.go_java4.alex_mirn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPoolImpl implements ConnectionPool {
//	private static final String SQL_URL = "jdbc:postgresql://localhost:5432/kickstarter";
//	private static final String SQL_URL = "jdbc:postgresql:C:\\workspace2\\kickstarterX\\resources\\database.db";
//	private static final String SQL_USER = "postgres";
//	private static final String SQL_PASSWORD = "1qw23er45t";
//	private String SQL_URL;
//	private String SQL_USER;
//	private String SQL_PASSWORD;

//	private Connection connection;
	@Autowired
	private DataSource dataSource;
	
	public ConnectionPoolImpl() throws SQLException {
//		this.dataSource = dataSource;
//		this.connection = DriverManager.getConnection(
//				SQL_URL, SQL_USER, SQL_PASSWORD);
//		this.connection = connection;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void close() throws Exception {
//		dataSource.close();
//		//		connection.close();
//	}

//	@Override
//	public Connection getConnection() {
//		return dataSource;
//		//		return connection;
//	}
}
