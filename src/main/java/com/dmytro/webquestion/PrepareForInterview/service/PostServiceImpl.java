package com.dmytro.webquestion.PrepareForInterview.service;


import com.dmytro.webquestion.PrepareForInterview.entity.Post;
import com.dmytro.webquestion.PrepareForInterview.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(long id) {
        Post post = null;
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()){
            post = optional.get();
        }
        return post;
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public boolean existsPostById(long id) {
        return postRepository.existsById(id);
    }

//    @Override
//    public List<Post> findAllByName(String name) {
//        List<Post> employees = postRepository.findAllByName(name);
//        return employees;
//    }
}
