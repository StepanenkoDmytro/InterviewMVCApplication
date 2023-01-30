package com.dmytro.webquestion.PrepareForInterview.service;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;

import java.util.List;

public interface TopicJavaDevService {
    List<TopicJavaDeveloper> getAllTopicsJavaDev();
    void saveTopicJavaDec(TopicJavaDeveloper topic);
    TopicJavaDeveloper getTopicJavaDevById(long id);
    void deleteTopicJavaDev(long id);
    boolean existsTopicJavaDevById(long id);
    List<QuestionTopic> getListQuestionsTopic(TopicJavaDeveloper topicJavaDeveloper);

}
