package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.models.Filme;
@Repository
public interface RepositoryFilmes extends MongoRepository<Filme, String> {

}
