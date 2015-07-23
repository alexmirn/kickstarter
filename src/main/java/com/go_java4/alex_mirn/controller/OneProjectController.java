package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.entity.Answer;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Question;
import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.service.ProjectService;
import com.go_java4.alex_mirn.service.QuestionService;
import com.go_java4.alex_mirn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/oneProject")
public class OneProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

//    @Autowired
//    ProjectServiceQuestions projectServiceQuestions
//
//    @Autowired
//    ProjectServiceAnswers projectServiceAnswers

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String showOneProject(ModelMap model, @PathVariable String projectId) {
        int intProject = Integer.valueOf(projectId);
        Project oneProject = projectService.getById(intProject);
        List<Question> questions = questionService.getQuestionsOfProject(oneProject);
        model.addAttribute("oneProject", oneProject);
        model.addAttribute("user", userService.getById(1));
        model.addAttribute("questions", questions);

        return "oneProject";
    }
}
