package com.dmytro.webquestion.PrepareForInterview.controller;


import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import com.dmytro.webquestion.PrepareForInterview.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/v1/posts")
public class PostRESTController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<Post> showAllPosts(){
        List<Post> allPosts = postService.getAllPosts();
        return allPosts;
    }

}
