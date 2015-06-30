package com.go_java4.alex_mirn.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.go_java4.alex_mirn.model.dao.CategoriesDao;
import com.go_java4.alex_mirn.model.dao.CategoriesDaoImpl;
import com.go_java4.alex_mirn.model.dao.Dao;
import com.go_java4.alex_mirn.model.dao.DaoImpl;
import com.go_java4.alex_mirn.model.dao.ProjectsDao;
import com.go_java4.alex_mirn.model.dao.ProjectsDaoImpl;
import com.go_java4.alex_mirn.model.dao.QuotesDao;
import com.go_java4.alex_mirn.model.dao.QuotesDaoImpl;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.util.ConnectionPool;
import com.go_java4.alex_mirn.util.ConnectionPoolImpl;

//@WebServlet("/")
@Controller
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with postgres driver", e);
		}
	}
	
	public MainServlet(){}

	@Autowired
	DataSource dataSource;
	
	@Autowired
	CategoriesDao categoriesDB;
	
	@Autowired
	QuotesDao quotesDB;

	@Autowired
	ProjectsDao projectsDB;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, 
													config.getServletContext());
//		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        beanFactory.autowireBean(this);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = getAction(req);
		req.getSession().setAttribute("connection", dataSource);
		try {
			if (action.startsWith("/categories")) {
				Quote quote = quotesDB.getRandomQuote();
				req.setAttribute("quote", quote);
				ArrayList<Category> categories = (ArrayList<Category>) categoriesDB.getAll();
				req.setAttribute("categories", categories);
				req.getRequestDispatcher("categories.jsp").forward(req, resp);
			} else if (action.startsWith("/projects")) {
				int categoryId = Integer.valueOf(req.getParameter("category"));
				ArrayList<Project> projects = (ArrayList<Project>) projectsDB.getProjectsInCategory(categoryId);
				req.setAttribute("projects", projects);
				req.getRequestDispatcher("projects.jsp").forward(req, resp);
			} else if (action.startsWith("/oneProject")) {
				int projectId = Integer.valueOf(req.getParameter("project"));
				Project project = (Project) projectsDB.getProjectIndex(projectId);
				req.setAttribute("oneProject", project);
				req.getRequestDispatcher("oneProject.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Problems with creating of connection", e);
		}
	}

	private String getAction(HttpServletRequest req) {
		String requestUri = req.getRequestURI();
		String action = requestUri.substring(req.getContextPath().length(), requestUri.length());
		return action;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
