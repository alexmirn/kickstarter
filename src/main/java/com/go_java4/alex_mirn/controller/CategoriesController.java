package com.go_java4.alex_mirn.controller;


import com.go_java4.alex_mirn.service.CategoryService;
import com.go_java4.alex_mirn.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    QuoteService quoteService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories(ModelMap model) {

        model.addAttribute("quote", quoteService.getRandom());
        model.addAttribute("categories", categoryService.getAll());
        return "categories";
    }
}