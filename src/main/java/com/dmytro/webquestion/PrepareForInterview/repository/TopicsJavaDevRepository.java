package com.dmytro.webquestion.PrepareForInterview.repository;

import com.dmytro.webquestion.PrepareForInterview.entity.TopicJavaDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsJavaDevRepository extends JpaRepository<TopicJavaDeveloper,Long> {
}
