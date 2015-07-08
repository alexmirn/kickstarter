package com.go_java4.alex_mirn.model.dao;


//public interface dao extends QuoteDao, CategoriesDao, ProjectsDao {
public interface Dao<T> {

	void create(T entity);
	T getById(Integer id);
	void update(T entity);
	void delete(T entity);
}
