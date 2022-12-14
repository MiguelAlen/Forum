package com.example.forum.infrastructure.repository;

import com.example.forum.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
        List<Usuario> findById(Integer id);
        Optional<Usuario> findByEmail(String email);
        void deleteById(Integer id);
}
