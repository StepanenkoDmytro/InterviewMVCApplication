package com.dmytro.webquestion.PrepareForInterview.service;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;
import com.dmytro.webquestion.PrepareForInterview.repository.QuestionTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTopicServiceImpl implements QuestionTopicService {

    @Autowired
    QuestionTopicRepository questionTopicRepository;

    @Override
    public List<QuestionTopic> getAllQuestionsTopic() {
        return questionTopicRepository.findAll();
    }

    @Override
    public void saveQuestion(QuestionTopic question) {
        questionTopicRepository.save(question);
    }

    @Override
    public QuestionTopic getQuestion(long id) {
        QuestionTopic question = null;
        Optional<QuestionTopic> optional = questionTopicRepository.findById(id);
        if(optional.isPresent()){
            question = optional.get();
        }
        return question;
    }

    @Override
    public void deleteQuestion(long id) {
        questionTopicRepository.deleteById(id);
    }

    @Override
    public boolean existsQuestion(long id) {
        return questionTopicRepository.existsById(id);
    }
}
