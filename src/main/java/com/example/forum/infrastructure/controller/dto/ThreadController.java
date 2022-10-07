package com.example.forum.infrastructure.controller.dto;

import com.example.forum.application.ThreadService;
import com.example.forum.domain.Thread;
import com.example.forum.infrastructure.controller.dto.input.ThreadInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("thread")
@RestController
@CrossOrigin
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @PostMapping
    public ResponseEntity<?> createThread(@RequestBody ThreadInputDto threadInputDto) throws Exception {
        return threadService.addThread(threadInputDto);
    }

    @GetMapping
    public List<Thread> getAllThreads() throws Exception {
        return threadService.getAllThreads();
    }
}
