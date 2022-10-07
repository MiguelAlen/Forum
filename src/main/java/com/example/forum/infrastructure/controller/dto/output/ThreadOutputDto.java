package com.example.forum.infrastructure.controller.dto.output;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ThreadOutputDto {
    private Long id;

    private String title;
    private Date date;
    private String author;
}
