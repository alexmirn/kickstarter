package com.go_java4.alex_mirn.model.template;

import com.go_java4.alex_mirn.model.dao.DaoTemplate;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.mapper.CategoryMapper;
import com.go_java4.alex_mirn.model.mapper.QuoteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yalex on 01.07.15.
 */
public class CategoryJDBCTemplate implements DaoTemplate<Category> {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Category entity) {
        String sql = "INSERT INTO category VALUES (?);";
        jdbcTemplate.update(sql, entity.getName());
        return;
    }

    @Override
    public Category getById(Integer id) {
        String sql = "SELECT * FROM category WHERE category_id = ?;";

        Object[] args = new Object[] {id};

        Category category = jdbcTemplate.queryForObject(sql, args, new CategoryMapper());
        return category;
    }

    @Override
    public void update(Category entity) {
        String sql = "UPDATE category SET category_name = ? WHERE category_id = ?;";
        jdbcTemplate.update(sql, entity.getName(), entity.getId());
        return;
    }

    @Override
    public void delete(Category entity) {
        String sql = "DELETE FROM category WHERE category_id = ?;";
        jdbcTemplate.update(sql, entity.getId());
        return;
    }

    public List<Category> getAll() {
        String sql = "SELECT * FROM category;";
        List categories = jdbcTemplate.query(sql, new CategoryMapper());
        return categories;
    }
}
