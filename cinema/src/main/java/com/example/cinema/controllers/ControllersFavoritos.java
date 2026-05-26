package com.example.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/favoritos")
public class ControllersFavoritos {
 @Autowired
 private ServicesFavorito servicesFavorito;

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

 // DELETE
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletarFavorito(
   @PathVariable String id) {

  servicesFavorito.deleteFavorito(id);

  return ResponseEntity.noContent().build();
 }
}
