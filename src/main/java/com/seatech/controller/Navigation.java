package com.seatech.controller;

import com.seatech.service.group_service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Navigation {
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("user_verify") != null)
            return "redirect:/product/allProduct";
        return "login";
    }

    @RequestMapping(value = "/add-page")
    public String addPage(ModelMap modelMap) {
        modelMap.addAttribute("groups", groupService.getAll());
        return "add-page";
    }

    @RequestMapping(value = "/edit-page")
    public String editPage(ModelMap modelMap) {
        modelMap.addAttribute("groups", groupService.getAll());
        return "edit-page";
    }
}
