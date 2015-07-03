package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.dao.template.QuoteJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteService {

    public QuoteService(){}

    @Autowired
    private QuoteJDBCTemplate quoteJDBCTemplate;

    public Quote getRandom() {
        return quoteJDBCTemplate.getRandom();
    }

    public void setQuoteJDBCTemplate(QuoteJDBCTemplate quoteJDBCTemplate) {
        this.quoteJDBCTemplate = quoteJDBCTemplate;
    }

    public QuoteJDBCTemplate getQuoteJDBCTemplate() {

        return quoteJDBCTemplate;
    }
}
