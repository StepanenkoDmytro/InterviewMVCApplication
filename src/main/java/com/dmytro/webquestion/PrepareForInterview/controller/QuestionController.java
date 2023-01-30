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
public class QuestionController {
    @Autowired
    QuestionTopicService questionTopicService;
    @Autowired
    TopicJavaDevService topicJavaDevService;

    @GetMapping("/v1/interview/addQuestion")
    public String setQuestionTopic(Model model){
        List<TopicJavaDeveloper> list = topicJavaDevService.getAllTopicsJavaDev();
        model.addAttribute("list_topics", list);
        return "interview-add-questions";
    }

    @PostMapping("/v1/interview/addQuestion")
    public String saveQuestionTopic(@RequestParam(name = "topicId") long id,
                           @RequestParam String question,
                           @RequestParam String answer,
                           Model model){
        QuestionTopic questionTopic = new QuestionTopic();
        questionTopic.setQuestion(question);
        questionTopic.setAnswer(answer);
        TopicJavaDeveloper topic = topicJavaDevService.getTopicJavaDevById(id);
        questionTopic.setTopic(topic);
        questionTopicService.saveQuestion(questionTopic);
        return "redirect:/v1/interview/" + id;
    }

    @GetMapping("/v1/interview/editQuestion/{id}")
    public String getEditQuestionTopic(@PathVariable(name = "id") long id, Model model){
        if(!questionTopicService.existsQuestion(id)){
            return "redirect:/v1/interview";//переписати на свою 404 сторінку
        }
        QuestionTopic question = questionTopicService.getQuestion(id);
        model.addAttribute("question",question);

        List<TopicJavaDeveloper> list = topicJavaDevService.getAllTopicsJavaDev();
        model.addAttribute("list_topics", list);
        return "interview-edit-question";
    }

    @PostMapping("/v1/interview/editQuestion/{id}")
    public String updateQuestionTopic(@PathVariable(name = "id") long idq,
                                      @RequestParam(name = "topicId") long id,
                                    @RequestParam String question,
                                    @RequestParam String answer,
                                    Model model){
        QuestionTopic questionTopic = new QuestionTopic();
        questionTopic.setQuestion(question);
        questionTopic.setAnswer(answer);
        TopicJavaDeveloper topic = topicJavaDevService.getTopicJavaDevById(id);
        questionTopic.setTopic(topic);
        questionTopicService.saveQuestion(questionTopic);
        return "redirect:/v1/interview/" + id;
    }

    @PostMapping("/v1/interview/editQuestion/{id}/remove")
    public String removeTopicJV(@PathVariable(name = "id") long id, Model model){
        questionTopicService.deleteQuestion(id);
        return "redirect:/v1/interview";
    }

}
