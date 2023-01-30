package com.dmytro.webquestion.PrepareForInterview.controller;

import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import com.dmytro.webquestion.PrepareForInterview.repository.PostRepository;
import com.dmytro.webquestion.PrepareForInterview.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/v1/blog")
    public String getAllPosts(Model model){
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("allPosts",allPosts);
        return "blog-main";
    }
    @GetMapping("/v1/blog/add")
    public String addNewPost(Model model){
        return "blog-add";
    }
    @PostMapping("/v1/blog/add")
    public String savePost(@RequestParam String name,
                           @RequestParam String anons,
                           @RequestParam String full_text,
                           Model model){
        Post post = new Post(name,anons,full_text);
        postService.savePost(post);
        return "redirect:/v1/blog";
    }

    @GetMapping("/v1/blog/{id}")
    public String getPost(@PathVariable(value = "id") long id, Model model){
        if(!postService.existsPostById(id)){
            return "redirect:/v1/blog";//переписати на свою 404 сторінку
        }
        Post post = postService.getPost(id);
        model.addAttribute("post",post);
        return "blog-details";
    }
    @GetMapping("/v1/blog/{id}/edit")
    public String getEditPost(@PathVariable(value = "id") long id, Model model){
        if(!postService.existsPostById(id)){
            return "redirect:/v1/blog";//переписати на свою 404 сторінку
        }
        Post post = postService.getPost(id);
        model.addAttribute("post",post);
        return "blog-edit";
    }

    @PostMapping("/v1/blog/{id}/edit")
    public String updatePost(@PathVariable(name = "id") long id,
                             @RequestParam String name,
                             @RequestParam String anons,
                             @RequestParam String full_text,
                             Model model){
        Post post = postService.getPost(id);
        post.setName(name);
        post.setAnons(anons);
        post.setFullText(full_text);
        postService.savePost(post);
        return "redirect:/v1/blog";
    }
    @PostMapping("/v1/blog/{id}/remove")
    public String removePost(@PathVariable(name = "id") long id, Model model){
        postService.deletePost(id);
        return "redirect:/v1/blog";
    }
}
