package com.dmytro.webquestion.PrepareForInterview.controller;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;
import com.dmytro.webquestion.PrepareForInterview.service.QuestionTopicService;
import com.dmytro.webquestion.PrepareForInterview.service.TopicJavaDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InterviewController {

    @Autowired
    TopicJavaDevService topicJavaDevService;
    @Autowired
    QuestionTopicService questionTopicService;


    @GetMapping("/v1/interview")
    public String getAllTopicsJavaDev(Model model){
        List<TopicJavaDeveloper> allTopics = topicJavaDevService.getAllTopicsJavaDev();
        model.addAttribute("allTopics", allTopics);
        return "interview-main";
    }

    @GetMapping("/v1/interview/add")
    public String addNewPost(Model model){
        return "interview-add";
    }

    @PostMapping("/v1/interview/add")
    public String savePost(@RequestParam String name,
                           @RequestParam String description,
                           Model model){
        TopicJavaDeveloper topic = new TopicJavaDeveloper();
        topic.setName(name);
        topic.setDescription(description);
        topicJavaDevService.saveTopicJavaDec(topic);
        return "redirect:/v1/interview";
    }

    @GetMapping("/v1/interview/{id}")
    public String getTopicJavaDev(@PathVariable(value = "id") long id, Model model){
        if(!topicJavaDevService.existsTopicJavaDevById(id)){
            return "redirect:/v1/interview";//переписати на свою 404 сторінку
        }
        TopicJavaDeveloper topic = topicJavaDevService.getTopicJavaDevById(id);
        model.addAttribute("topic",topic);

        List<QuestionTopic> allQuestions = topic.getQuestionToTopic();
        model.addAttribute("allQuestions", allQuestions);

        return "interview-details";
    }
    @GetMapping("/v1/interview/{id}/edit")
    public String getEditTopicJV(@PathVariable(value = "id") long id, Model model){
        if(!topicJavaDevService.existsTopicJavaDevById(id)){
            return "redirect:/v1/interview";//переписати на свою 404 сторінку
        }
        TopicJavaDeveloper topic = topicJavaDevService.getTopicJavaDevById(id);
        model.addAttribute("topic",topic);
        return "interview-edit";
    }

    @PostMapping("/v1/interview/{id}/edit")
    public String updatePost(@PathVariable(name = "id") long id,
                             @RequestParam String name,
                             @RequestParam String description,
                             Model model){
        TopicJavaDeveloper topic = topicJavaDevService.getTopicJavaDevById(id);
        topic.setName(name);
        topic.setDescription(description);
        topicJavaDevService.saveTopicJavaDec(topic);
        return "redirect:/v1/interview/{id}";
    }
    @PostMapping("/v1/interview/{id}/remove")
    public String removeTopicJV(@PathVariable(name = "id") long id, Model model){
        topicJavaDevService.deleteTopicJavaDev(id);
        return "redirect:/v1/interview";
    }

}
