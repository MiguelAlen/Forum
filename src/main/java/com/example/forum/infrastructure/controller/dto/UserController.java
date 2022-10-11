package com.example.forum.infrastructure.controller.dto;

import com.example.forum.application.UserService;
import com.example.forum.domain.Usuario;
import com.example.forum.infrastructure.controller.dto.input.UserInputDto;
import com.example.forum.infrastructure.repository.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import java.util.List;
import java.util.Optional;

@RequestMapping("usuario")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    private final String UK_EMAIL = "UK_5171L57FAOSMJ8MYAWAUCATDW_INDEX_2";

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserInputDto userInputDto) throws Exception {



        try {
            userService.addUser(userInputDto);
        } catch(Exception e){
            if(e.getMessage().contains("UK_5171L57FAOSMJ8MYAWAUCATDW")){
                HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;
                JSONObject entity = new JSONObject();
                entity.put("error", "Email alrady exists");
                return ResponseEntity.status(httpStatus).body(entity.toString());
            }
        }
        HttpStatus httpStatus = HttpStatus.CREATED;
        return ResponseEntity.status(httpStatus).body("User registered successfully");
    }

    @GetMapping
    public List<Usuario> getAllUsuario() throws Exception{
        return userService.getAllUsuario();
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

    @GetMapping("/getLastUser")
    public Usuario getLastUsuario() throws Exception{
       return userService.getLastUsuario();
    }
}
