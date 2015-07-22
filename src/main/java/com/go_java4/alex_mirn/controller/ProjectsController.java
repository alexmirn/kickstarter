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

import java.util.ArrayList;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String showCategories(ModelMap model, @PathVariable String categoryId) {
        int categoryInt = Integer.valueOf(categoryId);
        ArrayList<Project> projects = (ArrayList<Project>)projectService.getProjectsInCategory(categoryInt);
        model.addAttribute("projects", projects);
        return "projects";
    }
}


//@Controller
//public class ProjectsServlet extends HttpServlet {
//
//    @Autowired
//    ProjectService projectService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int categoryId = Integer.valueOf(req.getParameter("category"));
//        ArrayList<Project> projects = (ArrayList<Project>) projectService.getProjectsInCategory(categoryId);
//        req.setAttribute("projects", projects);
//        req.getRequestDispatcher("projects.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // To DO
//    }
//
//    private String getAction(HttpServletRequest req) {
//        String requestUri = req.getRequestURI();
//        return requestUri.substring(req.getContextPath().length(), requestUri.length());
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
////		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
////													config.getServletContext());
//        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        beanFactory.autowireBean(this);
//    }
//}