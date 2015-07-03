package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.dao.template.CategoryJDBCTemplate;

import java.util.List;

public class CategoryService {

//    @Autowired
    private CategoryJDBCTemplate categoryJDBCTemplate;

    public List<Category> getAll() {
        return categoryJDBCTemplate.getAll();
    }

    public void setCategoryJDBCTemplate(CategoryJDBCTemplate categoryJDBCTemplate) {
        this.categoryJDBCTemplate = categoryJDBCTemplate;
    }

    public CategoryJDBCTemplate getCategoryJDBCTemplate() {
        return categoryJDBCTemplate;
    }
}
