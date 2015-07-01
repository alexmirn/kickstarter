package com.go_java4.alex_mirn.model.daoOld;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


public abstract class AbstractDaoImpl {
	private DataSource dataSource;
	
	Connection getConnectionPool() throws SQLException {
		return dataSource.getConnection();
	}
}
