package com.go_java4.alex_mirn.model.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.User;
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
public class ProjectDaoImplTest {
    @Autowired
    ProjectsDao projectsDao;

    @Autowired
    private UserDao userDao;

    Project project = new Project();

    @Test
    public void checkCreation() {
        project.setName("ololo");
        assertNotNull(project);
    }
    @Test
    public void getAllTest() throws Exception {
        ArrayList<Project> projects = (ArrayList<Project>) projectsDao.getProjectsInCategory(1);
        Assert.assertEquals("value 1", projects.get(0).getName());
        Assert.assertEquals("value 2", projects.get(1).getName());
    }

    @Test
    public void getByIdTest() {
        Project project = projectsDao.getById(1);
        Assert.assertEquals("value 1", project.getName());
    }

//    TODO!!!!!!!!!!!!!!!!
//    @Test
//    @Rollback(false)
//    @ExpectedDatabase(
//            value = "classpath:projectTest/expectedCreateData.xml",
//            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, // in expected dataSet may not be not all columns
//            table = "project"
//    )
//    public void testCreate() throws Exception {
//        Project project = new Project(new Category(1,"value 1"),"created project", "created description",
//                1, 1, 1, new User(2,"user","user", "alex_mirn2@gmail.com", "user_name"));
//        projectsDao.create(project);
//    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:projectTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED,
            table = "project"
    )
    public void testUpdate() throws Exception {
        Project updateProject = projectsDao.getById(3);
        updateProject.setName("updated project");
        projectsDao.update(updateProject);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(
            value = "classpath:projectTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED,
            table = "project"
    )
    public void testDelete() throws Exception {
        Project deleteProject = projectsDao.getById(2);
        projectsDao.delete(deleteProject);
    }
}
