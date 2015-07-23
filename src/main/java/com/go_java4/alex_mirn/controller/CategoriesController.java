package com.go_java4.alex_mirn.controller;


import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.service.CategoryService;
import com.go_java4.alex_mirn.service.QuoteService;
import com.go_java4.alex_mirn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    QuoteService quoteService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories(ModelMap model) {

        model.addAttribute("quote", quoteService.getRandom());
        model.addAttribute("categories", categoryService.getAll());
        return "categories";
    }

    @RequestMapping(value = "/kickstarter/register", method = RequestMethod.POST)
    public String registerUser(
//          model.addAttribute("userLogin", user.getLogin());
//          model.addAttribute("userPassword", user.getPassword());
//          model.addAttribute("userEmail", user.getLogin());
//          model.addAttribute("userName", user.getName());
                               User user, ModelMap model, BindingResult result) {
//        System.out.println(login);
//                               BindingResult result, ModelMap model) {
//            , BindingResult result, SessionStatus status) {
//        User user = new User(login, password, email, userName);
//        userService.createUser(user);
//        status.setComplete();
        model.addAttribute("quote", "Aleshen`ka");
        model.addAttribute("categories", categoryService.getAll());
        return "categories";
    }
}

