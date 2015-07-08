package com.go_java4.alex_mirn.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.go_java4.alex_mirn.model.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDao")
@Transactional
public class CategoriesDaoImpl extends AbstractDao<Category> implements CategoriesDao {

	public CategoriesDaoImpl() {
		super(Category.class);
	}

	@Override
	public List<Category> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createCriteria(Category.class).list();
	}
}