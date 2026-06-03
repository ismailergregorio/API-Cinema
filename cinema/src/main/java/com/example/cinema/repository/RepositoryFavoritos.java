package com.example.cinema.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cinema.models.Favorito;
import com.example.cinema.models.Filme;
import java.util.List;


public interface RepositoryFavoritos extends MongoRepository<Favorito,String>{

 Optional<Favorito> findByUsuarioIdAndFilmeId(String id, String id2);
 List<Favorito> findByUsuarioId(String usuarioId);
 
}
