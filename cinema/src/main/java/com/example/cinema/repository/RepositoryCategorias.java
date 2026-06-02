package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cinema.models.Categorias;
import java.util.List;
import java.util.Optional;


public interface RepositoryCategorias extends MongoRepository<Categorias, Integer> {
}
