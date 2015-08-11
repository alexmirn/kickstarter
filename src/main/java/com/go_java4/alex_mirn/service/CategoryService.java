package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.CategoriesDao;
import com.go_java4.alex_mirn.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {

    @Autowired
    private CategoriesDao categoriesDao;

    public List<Category> getAll() {
        return categoriesDao.getAll();
    }

    public void create(Category category) {
        categoriesDao.create(category);
    }

    public void update(Category category) {
        categoriesDao.update(category);
    }

    public Category getById(Integer categoryId) {
        return categoriesDao.getById(categoryId);
    }

    public void delete(Category category) {
        categoriesDao.delete(category);
    }
}
