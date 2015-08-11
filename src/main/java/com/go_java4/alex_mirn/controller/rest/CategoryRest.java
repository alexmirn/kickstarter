package com.go_java4.alex_mirn.controller.rest;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.service.CategoryService;
import com.go_java4.alex_mirn.service.ProjectService;
import com.go_java4.alex_mirn.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/v1/category", headers = "Accept=application/json")
public class CategoryRest {

    @Autowired
    QuoteService quoteService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> showCategories(ModelMap model) {

        model.addAttribute("quote", quoteService.getRandom());
        model.addAttribute("listCategories", categoryService.getAll());
        return categoryService.getAll();
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public List<Project> showCategory(ModelMap modelMap, @PathVariable int categoryId) {
        Category category = categoryService.getById(categoryId);

        List<Project> projectsForCategory = projectService.getProjectsInCategory(categoryId);

        modelMap.addAttribute("projects", projectsForCategory);
        modelMap.addAttribute("category_name", category.getName());
        modelMap.addAttribute("category_id", categoryId);

        return projectsForCategory;
    }

    @RequestMapping(value = "/{categoryId}/delete", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int categoryId) {
        Category category = categoryService.getById(categoryId);
        categoryService.delete(category);
        return "redirect:/categories";
    }

    @ModelAttribute("allCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }
}
