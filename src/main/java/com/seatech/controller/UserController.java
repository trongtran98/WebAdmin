package com.seatech.controller;

import com.seatech.entity.User;
import com.seatech.service.logger_service.LoggerService;
import com.seatech.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LoggerService loggerService;
    @Autowired
    Environment env;

    @RequestMapping(value = "/login")
    public String doLogin(User user, ModelMap modelMap, HttpSession session) {
        User user_verify = loggerService.doLogin(user);
        if (user_verify == null) {
            modelMap.addAttribute("login_error", env.getProperty("fail.user.login"));
            return "login";
        }
        session.setAttribute("user_verify", user_verify);
        return "redirect:/product/allProduct";
    }
}
