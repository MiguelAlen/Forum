package com.example.forum.application;

import com.example.forum.domain.Usuario;
import com.example.forum.infrastructure.controller.dto.input.UserInputDto;
import com.example.forum.infrastructure.controller.dto.output.UserOutputDto;
import com.example.forum.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserImplementation implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUser(UserInputDto userInputDto) throws Exception {

        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!userInputDto.getEmail().matches(EMAIL_REGEX)) throw new Exception("Email is not valid");

        Usuario usuario = FormQuestionInputDtoToEntity(userInputDto);
        userRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ConcurrentHashMap<>(Map.of("Created!", "The User is successfully created")));
    }



    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> getAllUsuario() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Usuario getLastUsuario() throws Exception {
        return userRepository.findAll(Sort.by("id").descending()).get(0);
    }

    public Usuario FormQuestionInputDtoToEntity(UserInputDto userInputDto) {
        Usuario usuario = new Usuario();
        usuario.setName(userInputDto.getName());
        usuario.setEmail(userInputDto.getEmail());
        usuario.setPassword(userInputDto.getPassword());
        usuario.setImage(userInputDto.getImage());

        return usuario;
    }
}
