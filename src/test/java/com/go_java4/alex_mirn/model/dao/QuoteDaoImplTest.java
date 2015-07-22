package com.go_java4.alex_mirn.model.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.go_java4.alex_mirn.model.dao.QuoteDao;
import com.go_java4.alex_mirn.model.entity.Quote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class QuoteDaoImplTest {

    @Autowired
    QuoteDao quoteDao;

    Quote quote = new Quote();

    @Test
    public void checkCreation() {
        quote.setQuote("ololo");
        assertNotNull(quote);
    }
    @Test
    public void testGetRandom() throws Exception {
        Quote random = quoteDao.getRandom();
        Assert.assertNotNull(random);
    }

    @Test
    public void getByID() {
        Quote quoteTest = quoteDao.getById(1);
        System.out.println(quoteTest);
        Assert.assertEquals("value 1", quoteTest.getQuote());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT, // in expexted dataSet may not be not all columns
            table = "quote"
    )
    public void testCreate() throws Exception {
        Quote quote = new Quote("created value");
        quoteDao.create(quote);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "quote"
    )
    public void testUpdate() throws Exception {
        Quote updateQuote = quoteDao.getById(3);
        updateQuote.setQuote("updated value");
        quoteDao.update(updateQuote);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "quote"
    )
    public void testDelete() throws Exception {
        Quote deleteQuote = quoteDao.getById(2);
        quoteDao.delete(deleteQuote);
    }
}