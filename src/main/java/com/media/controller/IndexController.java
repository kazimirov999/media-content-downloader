package com.media.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Value("${welcome.message:test}")
    private String welcomeMessage;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("welcomeMessage", this.welcomeMessage);
        return "index";
    }

}