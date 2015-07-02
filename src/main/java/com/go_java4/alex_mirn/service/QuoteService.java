package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.template.QuoteJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yalex on 02.07.15.
 */
public class QuoteService {

    @Autowired
    private QuoteJDBCTemplate quoteJDBCTemplate;

    public Quote getRandom() {
        Quote quote = quoteJDBCTemplate.getRandom();
        return quote;
    }

    public void setQuoteJDBCTemplate(QuoteJDBCTemplate quoteJDBCTemplate) {
        this.quoteJDBCTemplate = quoteJDBCTemplate;
    }

    public QuoteJDBCTemplate getQuoteJDBCTemplate() {
        return quoteJDBCTemplate;
    }
}
