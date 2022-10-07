package com.example.forum.infrastructure.controller.dto.input;

import com.example.forum.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostInputDto {
    private String comment;
    private Date date;
    private String author;
    private String thread;

    private String category;

    public PostInputDto(Post post) {
        this.comment = post.getComment();
        this.date = post.getDate();
        this.author = post.getAuthor();
        this.thread = post.getThread();
        this.category = post.getCategory();
    }
}
