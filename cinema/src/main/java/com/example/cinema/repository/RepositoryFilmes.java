package com.example.cinema.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.models.Filme;
import java.util.List;

@Repository
public interface RepositoryFilmes extends MongoRepository<Filme, String> {
 List<Filme> findByGenreIds(Integer genreIds);

 List<Filme> findByTitleContainingIgnoreCase(String title);

 List<Filme> findTop10ByGenreIdsInOrderByVoteAverageDesc(List<Integer> genreIds);

 List<Filme> findTop20ByOrderByPopularityDescVoteAverageDescVoteCountDesc();
}


