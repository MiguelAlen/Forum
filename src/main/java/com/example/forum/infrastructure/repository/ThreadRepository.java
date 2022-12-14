package com.example.forum.infrastructure.repository;

import com.example.forum.domain.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
        List<Thread> findById(Integer id);
        void deleteById(Integer id);
}
