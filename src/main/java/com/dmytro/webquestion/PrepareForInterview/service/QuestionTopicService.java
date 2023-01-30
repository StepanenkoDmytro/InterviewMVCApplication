package com.dmytro.webquestion.PrepareForInterview.service;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;

import java.util.List;

public interface QuestionTopicService {
    List<QuestionTopic> getAllQuestionsTopic();
    void saveQuestion(QuestionTopic question);
    QuestionTopic getQuestion(long id);
    void deleteQuestion(long id);
    boolean existsQuestion(long id);
}
