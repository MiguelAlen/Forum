package com.example.forum.infrastructure.controller.dto.input;

import com.example.forum.domain.Thread;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ThreadInputDto {
    private String title;
    private Date date;
    private String author;

    public ThreadInputDto(Thread thread) {
        this.title = thread.getTitle();
        this.date = thread.getDate();
        this.author = thread.getAuthor();
    }
}
