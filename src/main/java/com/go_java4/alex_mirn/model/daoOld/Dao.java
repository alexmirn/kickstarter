package com.go_java4.alex_mirn.model.daoOld;

import com.go_java4.alex_mirn.util.ConnectionPool;

//public interface dao extends QuotesDao, CategoriesDao, ProjectsDao {
public interface Dao {
	
	ConnectionPool getConnectionPool();
}
