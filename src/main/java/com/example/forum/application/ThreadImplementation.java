package com.example.forum.application;

import com.example.forum.domain.Thread;
import com.example.forum.infrastructure.controller.dto.input.ThreadInputDto;
import com.example.forum.infrastructure.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ThreadImplementation implements ThreadService{
    @Autowired
    ThreadRepository threadRepository;

    @Override
    public ResponseEntity<?> addThread(ThreadInputDto threadInputDto) throws Exception {

        Thread thread = ThreadInputDtoToEntity(threadInputDto);
        threadRepository.save(thread);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ConcurrentHashMap<>(Map.of("Created!", "The Thread is successfully created")));
    }

    @Override
    public List<Thread> getAllThreads(){
        return threadRepository.findAll();
    }

    public Thread ThreadInputDtoToEntity(ThreadInputDto threadInputDto) {
        Thread thread = new Thread();
        thread.setTitle(threadInputDto.getTitle());
        thread.setAuthor(threadInputDto.getAuthor());
        thread.setDate(threadInputDto.getDate());

        return thread;
    }
}
