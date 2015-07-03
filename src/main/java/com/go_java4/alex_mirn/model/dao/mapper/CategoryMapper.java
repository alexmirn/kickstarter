package com.go_java4.alex_mirn.model.dao.mapper;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Quote;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt("category_id"));
        category.setName(resultSet.getString("category_name"));
        return category;
    }
}
