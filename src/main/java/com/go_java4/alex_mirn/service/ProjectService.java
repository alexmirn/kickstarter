package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.template.ProjectJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yalex on 02.07.15.
 */
public class ProjectService {
    @Autowired
    private ProjectJDBCTemplate projectJDBCTemplate;

    public List<Project> getAll() {
        List projects = projectJDBCTemplate.getAll();
        return projects;
    }

    public List<Project> getProjectsInCategory(int categoryId) {
        List projects = projectJDBCTemplate.getProjectsInCategory(categoryId);
        return projects;
    }

    public Project getById(Integer id) {
        Project project = projectJDBCTemplate.getById(id);
        return project;
    }
    public ProjectJDBCTemplate getProjectJDBCTemplate() {
        return projectJDBCTemplate;
    }

    public void setProjectJDBCTemplate(ProjectJDBCTemplate projectJDBCTemplate) {
        this.projectJDBCTemplate = projectJDBCTemplate;
    }
}
