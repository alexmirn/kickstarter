package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class OneProjectServlet extends HttpServlet {

    @Autowired
    ProjectService projectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int projectId = Integer.valueOf(req.getParameter("project"));
        Project project = projectService.getById(projectId);
        req.setAttribute("project", project);
        req.getRequestDispatcher("oneProject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // To DO
    }

    private String getAction(HttpServletRequest req) {
        String requestUri = req.getRequestURI();
        return requestUri.substring(req.getContextPath().length(), requestUri.length());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//													config.getServletContext());
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }
}
