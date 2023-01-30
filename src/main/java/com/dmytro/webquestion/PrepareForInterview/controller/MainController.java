package com.dmytro.webquestion.PrepareForInterview.controller;


import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import com.dmytro.webquestion.PrepareForInterview.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class MainController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title", "Main");
        return "main";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About");
        return "about";
    }

}
