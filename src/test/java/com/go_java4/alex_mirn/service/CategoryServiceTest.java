package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.CategoriesDao;
import com.go_java4.alex_mirn.model.entity.Category;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Mock
    CategoriesDao categoriesDao;

    @InjectMocks
    CategoryService categoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() throws Exception {
        when(categoriesDao.getAll()).thenReturn(new LinkedList<Category>());
        Assert.assertTrue(categoryService.getAll().size() == 0);
    }

}