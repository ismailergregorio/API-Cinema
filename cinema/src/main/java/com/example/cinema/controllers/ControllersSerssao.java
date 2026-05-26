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

import com.example.cinema.DTO.DTOPostSessao;
import com.example.cinema.models.Sessao;
import com.example.cinema.services.ServicesSessao;

@RestController
@RequestMapping("/sessao")
public class ControllersSerssao {
 @Autowired
 private ServicesSessao servicesSessao;

 // POST
 @PostMapping
 public ResponseEntity<Sessao> criarSessao(
   @RequestBody DTOPostSessao dados) {

  Sessao novaSessao = servicesSessao.criarSessao(dados);

  return ResponseEntity
    .status(HttpStatus.CREATED)
    .body(novaSessao);
 }

 // GET ALL
 @GetMapping
 public ResponseEntity<List<Sessao>> listarSessoes() {

  List<Sessao> sessoes = servicesSessao.listarSessoes();

  return ResponseEntity.ok(sessoes);
 }

 // GET BY ID
 @GetMapping("/{id}")
 public ResponseEntity<Sessao> buscarSessaoPorId(
   @PathVariable String id) {

  Sessao sessao = servicesSessao.buscarSessaoPorId(id);

  return ResponseEntity.ok(sessao);
 }

 // PUT
 @PutMapping("/{id}")
 public ResponseEntity<Sessao> atualizarSessao(
   @PathVariable String id,
   @RequestBody DTOPostSessao dados) {

  Sessao sessaoAtualizada = servicesSessao.atualizarSessao(id, dados);

  return ResponseEntity.ok(sessaoAtualizada);
 }

 // DELETE
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletarSessao(
   @PathVariable String id) {

  servicesSessao.deletarSessao(id);

  return ResponseEntity.noContent().build();
 }
}
