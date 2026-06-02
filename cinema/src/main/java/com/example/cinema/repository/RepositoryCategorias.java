package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cinema.models.Categorias;

public interface RepositoryCategorias extends MongoRepository<Categorias, String> {
    
}
