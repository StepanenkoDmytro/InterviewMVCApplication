package com.dmytro.webquestion.PrepareForInterview.service;


import com.dmytro.webquestion.PrepareForInterview.entity.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();

    public void savePost(Post post);
    public Post getPost(long id);
    public void deletePost(long id);
    public boolean existsPostById(long id);

}
