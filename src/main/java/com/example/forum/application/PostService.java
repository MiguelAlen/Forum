package com.example.forum.application;

import com.example.forum.domain.Post;
import com.example.forum.domain.Thread;
import com.example.forum.infrastructure.controller.dto.input.PostInputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    public ResponseEntity<?> addPost(PostInputDto postInputDto) throws Exception;
    List<Post> getAllPosts(String thread)throws Exception;
}
