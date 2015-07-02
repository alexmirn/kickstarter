package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.template.CategoryJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yalex on 02.07.15.
 */
public class CategoryService {

    @Autowired
    private CategoryJDBCTemplate categoryJDBCTemplate;

    public List<Category> getAll() {
        List categories = categoryJDBCTemplate.getAll();
        return categories;
    }

    public void setCategoryJDBCTemplate(CategoryJDBCTemplate categoryJDBCTemplate) {
        this.categoryJDBCTemplate = categoryJDBCTemplate;
    }

    public CategoryJDBCTemplate getCategoryJDBCTemplate() {
        return categoryJDBCTemplate;
    }
}
