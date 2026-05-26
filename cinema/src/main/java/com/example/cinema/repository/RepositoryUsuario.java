package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cinema.models.Usuario;
import java.util.List;
import java.util.Optional;


public interface RepositoryUsuario extends MongoRepository<Usuario,String>{
 Optional<Usuario> findByEmail(String email);
}
