package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.daoOld.CategoriesDao;
import com.go_java4.alex_mirn.model.daoOld.ProjectsDao;
import com.go_java4.alex_mirn.model.daoOld.QuotesDao;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.template.CategoryJDBCTemplate;
import com.go_java4.alex_mirn.model.template.ProjectJDBCTemplate;
import com.go_java4.alex_mirn.model.template.QuoteJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
	QuoteJDBCTemplate quoteJDBCTemplate;

    @Autowired
    CategoryJDBCTemplate categoryJDBCTemplate;

    @Autowired
    ProjectJDBCTemplate projectJDBCTemplate;

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
//		try {
			if (action.startsWith("/categories")) {
//				Quote quote = quotesDB.getRandomQuote();
				Quote quote = quoteJDBCTemplate.getRandom();
                req.setAttribute("quote", quote);
//                ArrayList<Category> categories = (ArrayList<Category>) categoriesDB.getAll();
                ArrayList<Category> categories = (ArrayList<Category>) categoryJDBCTemplate.getAll();
                req.setAttribute("categories", categories);
				req.getRequestDispatcher("categories.jsp").forward(req, resp);
			} else if (action.startsWith("/projects")) {
				int categoryId = Integer.valueOf(req.getParameter("category"));
//                Category category = new Category(categoryId, "o");
//                category.setId(categoryId);
//				ArrayList<Project> projects = (ArrayList<Project>) projectsDB.getProjectsInCategory(categoryId);
				ArrayList<Project> projects = (ArrayList<Project>) projectJDBCTemplate.getProjectsInCategory(categoryId);
				req.setAttribute("projects", projects);
				req.getRequestDispatcher("projects.jsp").forward(req, resp);
			} else if (action.startsWith("/oneProject")) {
				int projectId = Integer.valueOf(req.getParameter("project"));
//				Project project = projectsDB.getProjectIndex(projectId);
				Project project = projectJDBCTemplate.getById(projectId);
				req.setAttribute("oneProject", project);
				req.getRequestDispatcher("oneProject.jsp").forward(req, resp);
			}
//		} catch (SQLException e) {
//			throw new RuntimeException("Problems with creating of connection", e);
//		}
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
