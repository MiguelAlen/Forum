package com.example.forum.application;

import com.example.forum.domain.Post;
import com.example.forum.infrastructure.controller.dto.input.PostInputDto;
import com.example.forum.infrastructure.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PostImplementation implements PostService{
    @Autowired
    PostRepository postRepository;

    @Override
    public ResponseEntity<?> addPost(PostInputDto postInputDto) throws Exception {

        Post post = PostInputDtoToEntity(postInputDto);
        postRepository.save(post);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ConcurrentHashMap<>(Map.of("Created!", "The Post is successfully created")));
    }

    @Override
    public List<Post> getAllPosts(String thread){
        return postRepository.findByThread(thread);
    }

    public Post PostInputDtoToEntity(PostInputDto postInputDto) {
        Post post = new Post();
        post.setAuthor(postInputDto.getAuthor());
        post.setDate(postInputDto.getDate());
        post.setComment(postInputDto.getComment());
        post.setThread(postInputDto.getThread());
        post.setCategory(postInputDto.getCategory());

        return post;
    }
}
