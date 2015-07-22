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
@RequestMapping(value="/v1/project", headers = "Accept=application/json")
public class ProjectRest {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/{projectId}", method = RequestMethod.GET)
    public Project getById(@PathVariable int projectId) {
        return projectService.getById(projectId);
    }
}
