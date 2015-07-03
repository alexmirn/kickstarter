package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.dao.template.ProjectJDBCTemplate;

import java.util.List;

public class ProjectService {
//    @Autowired
    private ProjectJDBCTemplate projectJDBCTemplate;


    public List<Project> getProjectsInCategory(int categoryId) {
        return  projectJDBCTemplate.getProjectsInCategory(categoryId);
    }

    public Project getById(Integer id) {
        return projectJDBCTemplate.getById(id);
    }
    public ProjectJDBCTemplate getProjectJDBCTemplate() {
        return projectJDBCTemplate;
    }

    public void setProjectJDBCTemplate(ProjectJDBCTemplate projectJDBCTemplate) {
        this.projectJDBCTemplate = projectJDBCTemplate;
    }
}
