package com.example.forum.infrastructure.controller.dto.output;

import com.example.forum.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostOutputDto {
    private Long id;

    private String comment;
    private Date date;
    private String author;
    private String thread;

    public PostOutputDto(Post post) {
        this.id = post.getId();
        this.comment = post.getComment();
        this.date = post.getDate();
        this.author = post.getAuthor();
        this.thread = post.getThread();
    }
}
