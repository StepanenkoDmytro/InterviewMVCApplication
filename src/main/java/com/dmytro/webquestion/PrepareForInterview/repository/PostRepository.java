package com.dmytro.webquestion.PrepareForInterview.repository;


import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
