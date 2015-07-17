package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.ProjectsDao;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by yalex on 16.07.15.
 */
public class ProjectServiceTest {
    @Mock
    ProjectsDao projectsDao;

    @InjectMocks
    ProjectService projectService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() {
        Project project = new Project();
        Mockito.when(projectsDao.getById(1)).thenReturn(project);
        Assert.assertEquals(project, projectService.getById(1));
    }

    @Test
    public void testProjectsInCategory() {
        Project project = new Project();
        List<Project> projects = new LinkedList<Project>();
        projects.add(project);
        Mockito.when(projectsDao.getProjectsInCategory(1)).thenReturn(projects);
        Assert.assertEquals(projects, projectService.getProjectsInCategory(1));
    }
}