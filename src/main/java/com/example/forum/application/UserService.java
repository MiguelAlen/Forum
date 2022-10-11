package com.example.forum.application;

import com.example.forum.domain.Thread;
import com.example.forum.domain.Usuario;
import com.example.forum.infrastructure.controller.dto.input.UserInputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public ResponseEntity<?> addUser(UserInputDto userInputDto) throws Exception;
    public Optional<Usuario> getUserByEmail(String email) throws Exception;

    public List<Usuario> getAllUsuario() throws Exception;

    public Usuario getLastUsuario() throws Exception;
}
