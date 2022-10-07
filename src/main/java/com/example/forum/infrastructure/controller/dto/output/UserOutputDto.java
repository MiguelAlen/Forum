package com.example.forum.infrastructure.controller.dto.output;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOutputDto {
    private Long id;

    private String name;
    private String email;
    private String password;
    private String image;
}
