package com.example.cinema.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cinema.models.Favorito;
import com.example.cinema.models.Filme;

public interface RepositoryFavoritos extends MongoRepository<Favorito,String>{

 Optional<Filme> findByUsuarioIdAndFilmeId(String id, String id2);
 
}
