package com.dmytro.webquestion.PrepareForInterview.repository;

import com.dmytro.webquestion.PrepareForInterview.entity.QuestionTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTopicRepository extends JpaRepository<QuestionTopic, Long> {
}
