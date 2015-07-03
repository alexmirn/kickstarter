package com.go_java4.alex_mirn.model.dao.template;

import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.dao.mapper.QuoteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class QuoteJDBCTemplate implements Template<Quote> {
    private final String CREATE = "INSERT INTO quote (quote_name) VALUES (?);";
    private final String GET_BY_ID = "SELECT * FROM quote WHERE quote_id = ?;";
    private final String UPDATE = "UPDATE quote SET quote_name = ? WHERE quote_id = ?;";
    private final String DELETE = "DELETE FROM quote WHERE quote_id = ?;";
    private final String GET_RANDOM = "SELECT * FROM quote ORDER BY RANDOM() LIMIT 1;";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Quote entity) {
        jdbcTemplate.update(CREATE, entity.getQuote());
    }

    @Override
    public Quote getById(Integer id) {
        Object[] args = new Object[] {id};

        return jdbcTemplate.queryForObject(GET_BY_ID, args, new QuoteMapper());
    }

    @Override
    public void update(Quote entity) {
        jdbcTemplate.update(UPDATE, entity.getQuote(), entity.getId());
    }

    @Override
    public void delete(Quote entity) {
        jdbcTemplate.update(DELETE, entity.getId());
    }

    public Quote getRandom() {
        return jdbcTemplate.queryForObject(GET_RANDOM, new QuoteMapper());
    }
}
