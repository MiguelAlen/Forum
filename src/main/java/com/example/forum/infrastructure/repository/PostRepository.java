package com.example.forum.infrastructure.repository;

import com.example.forum.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findById(Integer id);
        void deleteById(Integer id);
        List<Post> findByThread(String thread);
}
