package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories(ModelMap model, @RequestParam String category) {
        int category1 = Integer.valueOf(category);
        System.out.println(category);
        ArrayList<Project> projects = (ArrayList<Project>)projectService.getProjectsInCategory(category1);
        System.out.println(projects.get(0));
        model.addAttribute("projects", projects);
        return "projects";
    }
}
