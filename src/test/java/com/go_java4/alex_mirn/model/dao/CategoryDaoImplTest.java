package com.go_java4.alex_mirn.model.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.go_java4.alex_mirn.model.entity.Category;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CategoryDaoImplTest {
    @Autowired
    CategoriesDao categoriesDao;

    @Test
    public void getAllTest() throws Exception {
        ArrayList<Category> categories = (ArrayList<Category>) categoriesDao.getAll();
        Assert.assertEquals("value 1", categories.get(0).getName());
        Assert.assertEquals("value 2", categories.get(1).getName());
        Assert.assertEquals("value 3", categories.get(2).getName());
    }

    @Test
    public void getByIdTest() {
        Category category = categoriesDao.getById(1);
        Assert.assertEquals("value 1", category.getName());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT, // in expected dataSet may not be not all columns
            table = "category"
    )
    public void testCreate() throws Exception {
        Category category = new Category("created category");
        categoriesDao.create(category);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "category"
    )
    public void testUpdate() throws Exception {
        Category updateCategory = categoriesDao.getById(3);
        updateCategory.setName("updated category");
        categoriesDao.update(updateCategory);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "category"
    )
    public void testDelete() throws Exception {
        Category deleteCategory = categoriesDao.getById(2);
        categoriesDao.delete(deleteCategory);
    }
}