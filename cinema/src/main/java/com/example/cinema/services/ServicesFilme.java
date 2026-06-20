package com.example.cinema.services;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cinema.DTO.DTOPostFilmes;
import com.example.cinema.models.Categorias;
import com.example.cinema.models.Favorito;
import com.example.cinema.models.Filme;
import com.example.cinema.repository.RepositoryCategorias;
import com.example.cinema.repository.RepositoryFavoritos;
import com.example.cinema.repository.RepositoryFilmes;

@Service
public class ServicesFilme {

  @Autowired
  private RepositoryFilmes repository;

  @Autowired
  RepositoryCategorias repositoryCategorias;

  @Autowired
  RepositoryFavoritos repositoryFavoritos;

  // ==================================================
  // CRIAR FILME
  // ==================================================

  public Filme createFilmes(DTOPostFilmes dto) {

    List<Categorias> categorias = dto.genreIds().stream()
        .map(id -> repositoryCategorias.findById(id)
            .orElse(null))
        .filter(Objects::nonNull)
        .toList();

    if (categorias.size() != dto.genreIds().size()) {

      throw new RuntimeException(
          "Uma ou mais categorias não existem.");
    }

    Filme filme = new Filme();
    filme.setId(dto.id());
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

          filme.setId(dto.id());
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

  public List<Filme> listaFilmesCategorias(Integer id) {
    return repository.findByGenreIds(id);
  }

  public List<Filme> BuscaFilmesNome(String nome) {
    return repository.findByTitleContainingIgnoreCase(nome);
  }

  public List<Filme> BuscarFilmesRecomendadosPorFavoritos(String userId) {
    List<Favorito> filmesFavoritos = repositoryFavoritos.findByUsuarioId(userId);

    if (filmesFavoritos.isEmpty()) {
      System.out.println("Nenhum filme favorito encontrado para o usuário: " + userId);
      return List.of();
    }

    List<Filme> filmes = filmesFavoritos.stream()
        .map(favorito -> repository.findById(favorito.getFilmeId()).orElse(null))
        .filter(Objects::nonNull)
        .toList();

    Set<Integer> categoriasFavoritas = filmes.stream()
        .flatMap(filme -> filme.getGenreIds().stream())
        .collect(Collectors.toSet());

    List<Filme> filmesRecomendados = repository
        .findTop10ByGenreIdsInOrderByVoteAverageDesc(categoriasFavoritas.stream().toList());
    System.out.println("Filmes recomendados para o usuário " + userId + ": " + filmesRecomendados);
    return filmesRecomendados;
  }

  public List<Filme> filmesSemelhantes() {

    // Busca todos os favoritos
    List<Favorito> favoritos = repositoryFavoritos.findAll();

    // Agrupa por filme
    Map<String, List<Favorito>> agrupados = favoritos.stream()
        .collect(Collectors.groupingBy(Favorito::getFilmeId));

    // Pega apenas os filmes favoritados por pelo menos 2 usuários
    List<String> filmesIds = agrupados.entrySet()
        .stream()
        .filter(entry -> entry.getValue().size() >= 2)
        .map(Map.Entry::getKey)
        .toList();

    // Busca os filmes
    return repository.findAllById(filmesIds);
  }
  public List<Filme> getFilmePorNome(String nome) {
    return repository.findByTitleContainingIgnoreCase(nome);
  }

  public List<Filme> getFilmesMaisVistos() {
    return repository.findTop20ByOrderByPopularityDescVoteAverageDescVoteCountDesc();
  }
}