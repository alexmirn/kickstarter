package com.go_java4.alex_mirn.model.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by yalex on 10.07.15.
 */
public class QuoteTest {
    Quote quote = new Quote();

    @Test
    public void checkCreation() {
        quote.setQuote("ololo");
        assertNotNull(quote);
    }



}
