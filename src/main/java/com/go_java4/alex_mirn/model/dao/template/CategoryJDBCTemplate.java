package com.go_java4.alex_mirn.model.dao.template;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.dao.mapper.CategoryMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


public class CategoryJDBCTemplate implements Template<Category> {
    private final String CREATE = "INSERT INTO category VALUES (?);";
    private final String GET_BY_ID = "SELECT * FROM category WHERE category_id = ?;";
    private final String UPDATE = "UPDATE category SET category_name = ? WHERE category_id = ?;";
    private final String DELETE = "DELETE FROM category WHERE category_id = ?;";
    private final String GET_ALL = "SELECT * FROM category;";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Category entity) {
        jdbcTemplate.update(CREATE, entity.getName());
    }

    @Override
    public Category getById(Integer id) {
        Object[] args = new Object[] {id};
        return jdbcTemplate.queryForObject(GET_BY_ID, args, new CategoryMapper());
    }

    @Override
    public void update(Category entity) {
        jdbcTemplate.update(UPDATE, entity.getName(), entity.getId());
    }

    @Override
    public void delete(Category entity) {
        jdbcTemplate.update(DELETE, entity.getId());
    }

    public List<Category> getAll() {
        return jdbcTemplate.query(GET_ALL, new CategoryMapper());
    }
}
