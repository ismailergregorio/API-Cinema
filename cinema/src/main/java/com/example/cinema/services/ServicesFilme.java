package com.example.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cinema.DTO.DTOPostFilmes;
import com.example.cinema.models.Filme;
import com.example.cinema.repository.RepositoryFilmes;

@Service
public class ServicesFilme {

  @Autowired
  private RepositoryFilmes repository;

  // ==================================================
  // CRIAR FILME
  // ==================================================

  public Filme createFilmes(DTOPostFilmes dto) {

    Filme filme = new Filme();

    filme.setTitle(dto.title());
    filme.setOriginalTitle(dto.originalTitle());
    filme.setOriginalLanguage(dto.originalLanguage());
    filme.setOverview(dto.overview());
    filme.setGenreIds(dto.genreIds());
    filme.setReleaseDate(dto.releaseDate());
    filme.setPosterPath(dto.posterPath());
    filme.setBackdropPath(dto.backdropPath());
    filme.setPopularity(dto.popularity());
    filme.setVoteAverage(dto.voteAverage());
    filme.setVoteCount(dto.voteCount());
    filme.setAdult(dto.adult());
    filme.setVideo(dto.video());
    filme.setSoftcore(dto.softcore());

    return repository.save(filme);
  }

  // ==================================================
  // LISTAR FILMES
  // ==================================================

  public List<Filme> getFilmes() {
    return repository.findAll();
  }

  // ==================================================
  // BUSCAR FILME POR ID
  // ==================================================

  public ResponseEntity<?> getFilme(String id) {

    Optional<Filme> filme = repository.findById(id);

    if (filme.isEmpty()) {

      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Filme não encontrado");
    }

    return ResponseEntity.ok(filme.get());
  }

  // ==================================================
  // ATUALIZAR FILME
  // ==================================================

  public ResponseEntity<?> updateFilme(
      String id,
      DTOPostFilmes dto) {

    Optional<Filme> filmeExistente = repository.findById(id);

    if (filmeExistente.isEmpty()) {

      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Filme não encontrado");
    }

    Filme filme = filmeExistente.get();

    filme.setTitle(dto.title());
    filme.setOriginalTitle(dto.originalTitle());
    filme.setOriginalLanguage(dto.originalLanguage());
    filme.setOverview(dto.overview());
    filme.setGenreIds(dto.genreIds());
    filme.setReleaseDate(dto.releaseDate());
    filme.setPosterPath(dto.posterPath());
    filme.setBackdropPath(dto.backdropPath());
    filme.setPopularity(dto.popularity());
    filme.setVoteAverage(dto.voteAverage());
    filme.setVoteCount(dto.voteCount());
    filme.setAdult(dto.adult());
    filme.setVideo(dto.video());
    filme.setSoftcore(dto.softcore());

    repository.save(filme);

    return ResponseEntity.ok(filme);
  }

  // ==================================================
  // DELETAR FILME
  // ==================================================

  public ResponseEntity<?> deleteFilme(String id) {

    Optional<Filme> filme = repository.findById(id);

    if (filme.isEmpty()) {

      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Filme não encontrado");
    }

    repository.delete(filme.get());

    return ResponseEntity.ok("Filme deletado com sucesso");
  }

  public List<Filme> createListaFilmes(List<DTOPostFilmes> dtos) {

    List<Filme> filmes = dtos.stream()
        .map(dto -> {
          Filme filme = new Filme();

          filme.setTitle(dto.title());
          filme.setOriginalTitle(dto.originalTitle());
          filme.setOriginalLanguage(dto.originalLanguage());
          filme.setOverview(dto.overview());
          filme.setGenreIds(dto.genreIds());
          filme.setReleaseDate(dto.releaseDate());
          filme.setPosterPath(dto.posterPath());
          filme.setBackdropPath(dto.backdropPath());
          filme.setPopularity(dto.popularity());
          filme.setVoteAverage(dto.voteAverage());
          filme.setVoteCount(dto.voteCount());
          filme.setAdult(dto.adult());
          filme.setVideo(dto.video());
          filme.setSoftcore(dto.softcore());

          return filme;
        })
        .toList();

    return repository.saveAll(filmes);
  }
}