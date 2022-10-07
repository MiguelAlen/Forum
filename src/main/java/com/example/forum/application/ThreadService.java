package com.example.forum.application;

import com.example.forum.domain.Thread;
import com.example.forum.infrastructure.controller.dto.input.ThreadInputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThreadService {
    public ResponseEntity<?> addThread(ThreadInputDto threadInputDto) throws Exception;

    public List<Thread> getAllThreads() throws Exception;
}
