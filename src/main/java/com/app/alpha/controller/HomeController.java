package com.app.alpha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String home(Model model){
        model.addAttribute("message","This home page");
        return "home/index";
    }

    @RequestMapping("/home/about")
    public String about(Model model){
        model.addAttribute("message","This home about");
        return "home/index";
    }
}
