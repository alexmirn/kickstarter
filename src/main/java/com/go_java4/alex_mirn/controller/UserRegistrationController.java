package com.go_java4.alex_mirn.controller;


import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.service.CategoryService;
import com.go_java4.alex_mirn.service.QuoteService;
import com.go_java4.alex_mirn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    QuoteService quoteService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories(ModelMap model) {

        return "userRegistration";
    }

    @RequestMapping(method = RequestMethod.POST)
//    public String addUser(@RequestParam("userLogin") String login,
//                                @RequestParam("userPassword") String password,
//                                @RequestParam("userEmail") String email,
//                                @RequestParam("userName") String name) {
    @ResponseBody
    public String addUser(ModelMap model,
                          @RequestParam(value="userLogin")  String login,
                          @RequestParam(value="userPassword") String password,
                          @RequestParam(value="userEmail") String email,
                          @RequestParam(value="userName") String name) {

        User user = new User(login, password, email, name);
        userService.createUser(user);
        return "categories";
    }

//
//    @RequestMapping(method = RequestMethod.GET, params = "new")
//    public ModelAndView addUser() {
//        return new ModelAndView("userAdd");
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView addUser(@RequestParam("userLogin") String login,
//                                @RequestParam("userPassword") String password,
//                                @RequestParam("userEmail") String email,
//                                @RequestParam("userName") String name) {
//        User user = new User(login, password, email, name);
//        userService.createUser(user);
//        return new ModelAndView("categories");
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String register(ModelMap model) {
//
//        model.addAttribute("quote", quoteService.getRandom());
//        model.addAttribute("categories", categoryService.getAll());
//        return "categories";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String showCategories(ModelMap model) {
//
//        model.addAttribute("quote", quoteService.getRandom());
//        model.addAttribute("categories", categoryService.getAll());
//        return "categories";
//    }

//    @RequestMapping(value = "/kickstarter/register", method = RequestMethod.POST)
//    public String registerUser(
////          model.addAttribute("userLogin", user.getLogin());
////          model.addAttribute("userPassword", user.getPassword());
////          model.addAttribute("userEmail", user.getLogin());
////          model.addAttribute("userName", user.getName());
//                               User user, ModelMap model, BindingResult result) {
////        System.out.println(login);
////                               BindingResult result, ModelMap model) {
////            , BindingResult result, SessionStatus status) {
////        User user = new User(login, password, email, userName);
////        userService.createUser(user);
////        status.setComplete();
//        model.addAttribute("quote", "Aleshen`ka");
//        model.addAttribute("categories", categoryService.getAll());
//        return "categories";
//    }
}

