package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.QuoteDao;
import com.go_java4.alex_mirn.model.entity.Quote;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class QuoteServiceTest {
    @Mock
    QuoteDao quoteDao;

    @InjectMocks
    QuoteService quoteService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRandomQuotest() {
        Mockito.when(quoteDao.getRandom()).thenReturn(new Quote("testQuote"));

        Assert.assertEquals("testQuote", quoteService.getRandom().getQuote());
    }
}