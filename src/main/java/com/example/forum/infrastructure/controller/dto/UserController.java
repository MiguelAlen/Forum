package com.example.forum.infrastructure.controller.dto;

import com.example.forum.application.UserService;
import com.example.forum.domain.Usuario;
import com.example.forum.infrastructure.controller.dto.input.UserInputDto;
import com.example.forum.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("usuario")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserInputDto userInputDto) throws Exception {

        return userService.addUser(userInputDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserInputDto userInputDto) throws Exception {
        ResponseEntity<?> response;

        Optional<Usuario> usuario = userService.getUserByEmail(userInputDto.getEmail());
        if(!usuario.isPresent()){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if(usuario.get().getPassword().equals(userInputDto.getPassword())){
            response = new ResponseEntity<>(HttpStatus.OK);
        }else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
