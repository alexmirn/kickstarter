package com.go_java4.alex_mirn.model.daoOld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

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