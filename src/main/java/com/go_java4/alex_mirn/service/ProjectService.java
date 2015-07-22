package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.ProjectsDao;
import com.go_java4.alex_mirn.model.dao.UserDao;
import com.go_java4.alex_mirn.model.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectService")
@Transactional
public class ProjectService {

    @Autowired
    private ProjectsDao projectsDao;

//    @Autowired
//    private UserDao userDao;

    public List<Project> getProjectsInCategory(int categoryId) {
        return  projectsDao.getProjectsInCategory(categoryId);
    }

    public Project getById(int projectId) {
        return  projectsDao.getById(projectId);
    }
//public List<Project> getProjectsInCategory(Category category) {
//    return  projectsDao.getProjectsInCategory(category);
//}
}
