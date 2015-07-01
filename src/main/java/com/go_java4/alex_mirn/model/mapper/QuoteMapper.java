package com.go_java4.alex_mirn.model.mapper;

import com.go_java4.alex_mirn.model.entity.Quote;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yalex on 01.07.15.
 */
public class QuoteMapper implements RowMapper<Quote> {

    @Override
    public Quote mapRow(ResultSet resultSet, int i) throws SQLException {
        Quote quote = new Quote();
        quote.setId(resultSet.getInt("quote_id"));
        quote.setQuote(resultSet.getString("quote_name"));
        return quote;
    }
}

