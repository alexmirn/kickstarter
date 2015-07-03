package com.go_java4.alex_mirn.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.go_java4.alex_mirn.model.dao.template.QuoteJDBCTemplate;
import com.go_java4.alex_mirn.model.entity.Quote;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
//@DatabaseSetup(value = "classpath:application-context-test.xml")
public class QuoteServiceTest extends TestCase {

    @Autowired
    private QuoteJDBCTemplate quoteJDBCTemplate;

    @Test
    public void testGetRandomQuote() throws Exception {
        int a;
        a = 5;
        assertEquals(5, a);
        Quote quote = quoteJDBCTemplate.getRandom();
        System.out.println(quote);
        assertNotNull(quote);
    }
}
