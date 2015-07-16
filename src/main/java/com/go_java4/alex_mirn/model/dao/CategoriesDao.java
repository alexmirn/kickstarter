package com.go_java4.alex_mirn.model.dao;

import java.util.List;

import com.go_java4.alex_mirn.model.entity.Category;
import org.springframework.transaction.annotation.Transactional;

public interface CategoriesDao extends Dao<Category> {

	@Transactional
	List<Category> getAll();
}
