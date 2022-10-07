package com.example.forum.infrastructure.controller.dto.input;

import com.example.forum.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInputDto {
    private String name;
    private String email;
    private String password;
    private String image;

    public UserInputDto(Usuario usuario) {
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.image = usuario.getImage();
    }
}
