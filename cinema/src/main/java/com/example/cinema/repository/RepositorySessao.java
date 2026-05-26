package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.models.Sessao;

@Repository
public interface RepositorySessao extends MongoRepository<Sessao,String>{
 
}
