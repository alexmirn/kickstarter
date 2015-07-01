package com.go_java4.alex_mirn.model.dao;


import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.util.ConnectionPool;
import com.go_java4.alex_mirn.util.ConnectionPoolImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoImpl implements Dao {
	private ConnectionPool connectionPool;
	private QuotesDao quotes;
	private CategoriesDao categories;
	private ProjectsDao projects;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with postgres driver", e);
		}
	}
	
//	public DaoImpl(Random random) throws IOException, SQLException {
	public DaoImpl() throws IOException, SQLException {
//		this.connectionPool = connectionPool;
//		this.quotes =quotes;
//		this.categories = categories;
//		this.projects = projects;
		
		
		this.connectionPool = new ConnectionPoolImpl();
//		this.quotes = new QuotesDaoImpl(connectionPool);
//		this.categories = new CategoriesDaoImpl(connectionPool);
//		this.projects = new ProjectsDaoImpl(connectionPool);
	}



public ConnectionPool getConnectionPool() {
		return connectionPool;
	}

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}
	
	public QuotesDao getQuotes() {
		return quotes;
	}



	public void setQuotes(QuotesDao quotes) {
		this.quotes = quotes;
	}



	public CategoriesDao getCategories() {
		return categories;
	}



	public void setCategories(CategoriesDao categories) {
		this.categories = categories;
	}



	public ProjectsDao getProjects() {
		return projects;
	}



	public void setProjects(ProjectsDao projects) {
		this.projects = projects;
	}


	//	@Override
	public List<Project> getProjectsInCategory(int index) throws SQLException {
		return projects.getProjectsInCategory(index);
	}
	
//	@Override
	public void add(Project project) throws SQLException {
		// TODO Auto-generated method stub	
	}	
	
//	@Override
	public int getProjectsSize() throws SQLException {
		return projects.getProjectsSize();
	}
	
//	@Override
	public Project getProjectIndex(int index) throws SQLException {
		return projects.getProjectIndex(index);
	}

//	@Override
	public List<Project> getAllProjects() throws SQLException {
		return projects.getAllProjects();
	}
	
//	@Override
	public void add(Category category) throws SQLException {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public Category getCategoriesIndex(int index) throws SQLException {
		return categories.getCategoriesIndex(index);
	}

//	@Override
	public int getCategoriesSize() throws SQLException {
		return categories.getCategoriesSize();
	}

//	@Override
	public List<Category> getAll() throws SQLException {
		return categories.getAll();
	}
		
//	@Override
	public void add(Quote quote) throws SQLException {
		quotes.add(quote);
	}

//	@Override
	public Quote getRandomQuote() throws SQLException {
		return quotes.getRandomQuote();
	}

//	@Override
	public void createTableQuotes() throws SQLException {
		quotes.createTableQuotes();
	}
}