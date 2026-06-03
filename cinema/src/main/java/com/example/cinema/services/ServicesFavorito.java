package com.example.cinema.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.DTO.DTOPostFavorito;
import com.example.cinema.models.Favorito;
import com.example.cinema.models.Filme;
import com.example.cinema.models.Usuario;
import com.example.cinema.repository.RepositoryFavoritos;
import com.example.cinema.repository.RepositoryFilmes;
import com.example.cinema.repository.RepositoryUsuario;

@Service
public class ServicesFavorito {

  @Autowired
  RepositoryFavoritos repositoryFavoritos;

  @Autowired
  RepositoryUsuario repositoryUsuario;

  @Autowired
  RepositoryFilmes repositoryFilmes;

  // POST
  public Favorito criarFavorito(DTOPostFavorito dados) {

    // Filme filme = repositoryFilmes.findById(dados.filmeId())
    //     .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

    Usuario usuario = repositoryUsuario.findById(dados.usuarioId())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    repositoryFavoritos
        .findByUsuarioIdAndFilmeId(
            usuario.getId(),
            dados.filmeId())
        .ifPresent(f -> {
          throw new RuntimeException(
              "Filme já favoritado");
        });

    // CRIA FAVORITO
    Favorito favorito = new Favorito();

    favorito.setUsuarioId(usuario.getId());
    favorito.setFilmeId(dados.filmeId());
    favorito.setDataCriacao(LocalDateTime.now());

    return repositoryFavoritos.save(favorito);
  }

  // GET ALL
  public Favorito bucasFavorito(String id) {
    return repositoryFavoritos.findById(id).orElseThrow(() -> new RuntimeException("Filme não disponivel"));
  }

  public Favorito buscarFavorioUser(String idUser, String idFilme) {

    Optional<Favorito> favorito = repositoryFavoritos.findByUsuarioIdAndFilmeId(
        idUser,
        idFilme);

    if (favorito.isPresent()) {
      return favorito.get();
    }

    return null;
  }

  public List<Favorito> buscarFilmesFavoritosUsuario(String id) {
    List<Favorito> idsFilmes = repositoryFavoritos.findByUsuarioId(id);
    return idsFilmes;
  }

  // GET
  public List<Favorito> bucarFavoritos() {
    return repositoryFavoritos.findAll();
  }

  public void deleteFavorito(String id) {
    Favorito favorito = repositoryFavoritos.findById(id)
        .orElseThrow(() -> new RuntimeException("Dados Não Encotrados"));
    repositoryFavoritos.delete(favorito);
  }

}
