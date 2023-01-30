package com.dmytro.webquestion.PrepareForInterview.controller;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;
import com.dmytro.webquestion.PrepareForInterview.service.QuestionTopicService;
import com.dmytro.webquestion.PrepareForInterview.service.TopicJavaDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExamController {
    @Autowired
    QuestionTopicService questionTopicService;
    @Autowired
    TopicJavaDevService topicJavaDevService;

    @GetMapping("/v1/exam")
    public String getRandomQuestion(Model model){
//        List<QuestionTopic> list = questionTopicService.getAllQuestionsTopic();
//        long randomNumberQuestion = (long) (Math.random()* list.size()+1);
//        QuestionTopic question = questionTopicService.getQuestion(randomNumberQuestion);
        QuestionTopic question = questionTopicService.getQuestion(7);
        model.addAttribute("question",question);
        return "exam-main";
    }
}
