package com.go_java4.alex_mirn.controller;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.service.CategoryService;
import com.go_java4.alex_mirn.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
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
import java.util.ArrayList;

@Controller
public class CategoriesServlet extends HttpServlet {
    @Autowired
    DataSource dataSource;

    @Autowired
    QuoteService quoteService;

//    @Autowired
//    CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        req.getSession().setAttribute("connection", dataSource);
        Quote quote = quoteService.getRandom();
        req.setAttribute("quote", quote);
//            ArrayList<Category> categories = (ArrayList<Category>) categoryService.getAll();
//            req.setAttribute("categories", categories);
//            req.getRequestDispatcher("categories.jsp").forward(req, resp);
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
