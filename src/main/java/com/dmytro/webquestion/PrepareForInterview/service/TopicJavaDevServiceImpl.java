package com.dmytro.webquestion.PrepareForInterview.service;

import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;
import com.dmytro.webquestion.PrepareForInterview.repository.TopicsJavaDevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicJavaDevServiceImpl implements TopicJavaDevService{

    @Autowired
    private TopicsJavaDevRepository topicsJavaDevRepository;

    @Override
    public List<TopicJavaDeveloper> getAllTopicsJavaDev() {
        return topicsJavaDevRepository.findAll();
    }

    @Override
    public void saveTopicJavaDec(TopicJavaDeveloper topic) {
        topicsJavaDevRepository.save(topic);
    }

    @Override
    public TopicJavaDeveloper getTopicJavaDevById(long id) {
        TopicJavaDeveloper topic = null;
        Optional<TopicJavaDeveloper> optional = topicsJavaDevRepository.findById(id);
        if(optional.isPresent()){
            topic = optional.get();
        }
        return topic;
    }

    @Override
    public void deleteTopicJavaDev(long id) {
        topicsJavaDevRepository.deleteById(id);
    }

    @Override
    public boolean existsTopicJavaDevById(long id) {
        return topicsJavaDevRepository.existsById(id);
    }

    @Override
    public List<QuestionTopic> getListQuestionsTopic(TopicJavaDeveloper topicJavaDeveloper) {
        return topicJavaDeveloper.getQuestionToTopic();
    }
}
