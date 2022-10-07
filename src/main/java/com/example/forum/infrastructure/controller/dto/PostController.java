package com.example.forum.infrastructure.controller.dto;

import com.example.forum.application.PostService;
import com.example.forum.domain.Post;
import com.example.forum.domain.Thread;
import com.example.forum.infrastructure.controller.dto.input.PostInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("post")
@RestController
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostInputDto postInputDto) throws Exception {
        return postService.addPost(postInputDto);
    }

    @GetMapping (path = "/{thread}")
    public List<Post> getAllPosts(@PathVariable String thread) throws Exception {
        return postService.getAllPosts(thread);
    }
}
