package com.go_java4.alex_mirn.model.template;

import com.go_java4.alex_mirn.model.dao.DaoTemplate;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.mapper.QuoteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by yalex on 01.07.15.
 */
public class QuoteJDBCTemplate implements DaoTemplate<Quote> {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Quote entity) {
        String sql = "INSERT INTO quote (quote_name) VALUES (?);";
        jdbcTemplate.update(sql, entity.getQuote());
        return;
    }

    @Override
    public Quote getById(Integer id) {
        String sql = "SELECT * FROM quote WHERE quote_id = ?;";

        Object[] args = new Object[] {id};

        Quote quote = jdbcTemplate.queryForObject(sql, args, new QuoteMapper());
        return quote;
    }

    @Override
    public void update(Quote entity) {
        String sql = "UPDATE quote SET quote_name = ? WHERE quote_id = ?;";
        jdbcTemplate.update(sql, entity.getQuote(), entity.getId());
        return;
    }

    @Override
    public void delete(Quote entity) {
        String sql = "DELETE FROM quote WHERE quote_id = ?;";
        jdbcTemplate.update(sql, entity.getId());
        return;
    }

    public Quote getRandom() {
        String sql = "SELECT * FROM quote ORDER BY RANDOM() LIMIT 1;";
        Quote quote = jdbcTemplate.queryForObject(sql, new QuoteMapper());
        return quote;
    }
}
