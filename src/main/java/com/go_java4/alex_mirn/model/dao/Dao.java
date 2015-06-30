package com.go_java4.alex_mirn.model.dao;

import java.sql.SQLException;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.util.ConnectionPool;

//public interface Dao extends QuotesDao, CategoriesDao, ProjectsDao {
public interface Dao {
	
	ConnectionPool getConnectionPool();
}
