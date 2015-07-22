package com.go_java4.alex_mirn.controller.rest;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/v1/category", headers = "Accept=application/json")
public class CategoryRest {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/projectsInCategory/{categoryId}", method = RequestMethod.GET)
    public List<Project> getProjectsInCategory(@PathVariable int categoryId) {
        return projectService.getProjectsInCategory(categoryId);
    }
}
