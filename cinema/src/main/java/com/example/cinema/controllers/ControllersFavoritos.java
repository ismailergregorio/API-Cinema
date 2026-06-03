package com.example.cinema.controllers;

import com.example.cinema.repository.RepositoryFavoritos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.DTO.DTOPostFavorito;
import com.example.cinema.models.Favorito;
import com.example.cinema.services.ServicesFavorito;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/favoritos")
@CrossOrigin(origins = "*")
public class ControllersFavoritos {
  private final RepositoryFavoritos repositoryFavoritos;
  @Autowired
  private ServicesFavorito servicesFavorito;

  ControllersFavoritos(RepositoryFavoritos repositoryFavoritos) {
    this.repositoryFavoritos = repositoryFavoritos;
  }

  // POST
  @PostMapping
  public ResponseEntity<Favorito> criarFavorito(
      @RequestBody DTOPostFavorito dados) {

    Favorito favorito = servicesFavorito.criarFavorito(dados);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(favorito);
  }

  // GET ALL
  @GetMapping
  public ResponseEntity<List<Favorito>> buscarFavoritos() {

    List<Favorito> favoritos = servicesFavorito.bucarFavoritos();

    return ResponseEntity.ok(favoritos);
  }

  // GET BY ID
  @GetMapping("/{id}")
  public ResponseEntity<Favorito> buscarFavorito(
      @PathVariable String id) {

    Favorito favorito = servicesFavorito.bucasFavorito(id);

    return ResponseEntity.ok(favorito);
  }

  @GetMapping("/{usuarioId}/{filmeId}")
  public ResponseEntity<Favorito> buscarItenFavoritado(
      @PathVariable String usuarioId,
      @PathVariable String filmeId) {

    Favorito itemFavorito = servicesFavorito.buscarFavorioUser(usuarioId, filmeId);

    if (itemFavorito == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(itemFavorito);
  }

  @GetMapping("listFavoritosUsuario/{id}")
  public ResponseEntity<List<Favorito>> listaFavoriosUsuario(@PathVariable String id) {
    return ResponseEntity.ok(servicesFavorito.buscarFilmesFavoritosUsuario(id));
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarFavorito(
      @PathVariable String id) {

    servicesFavorito.deleteFavorito(id);

    return ResponseEntity.noContent().build();
  }
}
