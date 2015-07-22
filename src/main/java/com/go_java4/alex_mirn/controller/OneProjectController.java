package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/oneProject")
public class OneProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String showOneProject(ModelMap model, @PathVariable String projectId) {
        int intProject = Integer.valueOf(projectId);
        Project oneProject = projectService.getById(intProject);
        model.addAttribute("oneProject", oneProject);
        return "oneProject";
    }
}
