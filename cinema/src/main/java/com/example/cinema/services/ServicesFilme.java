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
 RepositoryFilmes repository;

 // ==================================================
 // CRIAR FILME
 // ==================================================

 public Filme criateFilmes(
   DTOPostFilmes dto) {

  Filme filme = new Filme();

  filme.setTitulo(dto.titulo());
  filme.setGenero(dto.genero());
  filme.setDuracao(dto.duracao());
  filme.setClasificacao(dto.clasificacao());
  filme.setDiponivel(dto.diponivel());

  return repository.save(filme);
 }

 // ==================================================
 // DELETAR FILME
 // ==================================================

 public ResponseEntity<?> deleteFilme(
   String id) {

  Optional<Filme> filme = repository.findById(id);

  if (!filme.isPresent()) {

   return ResponseEntity
     .status(HttpStatus.NOT_FOUND)
     .body("Filme não encontrado");
  }

  repository.delete(filme.get());

  return ResponseEntity
    .status(HttpStatus.OK)
    .body("Filme deletado com sucesso");
 }

 // ==================================================
 // ATUALIZAR FILME
 // ==================================================

 public ResponseEntity<?> updateFilme(
   String id,
   DTOPostFilmes dto) {

  Optional<Filme> uspdadeFilme = repository.findById(id);

  if (!uspdadeFilme.isPresent()) {

   return ResponseEntity
     .status(HttpStatus.NOT_FOUND)
     .body("Filme não encontrado");
  }

  Filme filmeAtulizado = uspdadeFilme.get();

  filmeAtulizado.setTitulo(dto.titulo());
  filmeAtulizado.setDuracao(dto.duracao());
  filmeAtulizado.setGenero(dto.genero());
  filmeAtulizado.setDiponivel(dto.diponivel());
  filmeAtulizado.setClasificacao(dto.clasificacao());

  repository.save(filmeAtulizado);

  return ResponseEntity
    .status(HttpStatus.OK)
    .body(filmeAtulizado);
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

 public ResponseEntity<?> getFilme(
   String id) {

  Optional<Filme> filme = repository.findById(id);

  if (!filme.isPresent()) {

   return ResponseEntity
     .status(HttpStatus.NOT_FOUND)
     .body("Filme não encontrado");
  }

  return ResponseEntity
    .status(HttpStatus.OK)
    .body(filme.get());
 }
}