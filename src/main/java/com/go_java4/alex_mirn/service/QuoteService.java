package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.QuoteDao;
import com.go_java4.alex_mirn.model.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("quoteService")
@Transactional
public class QuoteService {

    @Autowired
    QuoteDao quoteDao;

    public Quote getRandom() {
        return quoteDao.getRandom();
    }
}