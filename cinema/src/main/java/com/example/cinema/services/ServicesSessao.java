package com.example.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.DTO.DTOPostSessao;
import com.example.cinema.models.Sessao;
import com.example.cinema.repository.RepositorySessao;

@Service
public class ServicesSessao {
 @Autowired
 private RepositorySessao repositorySessao;

 // POST
 public Sessao criarSessao(DTOPostSessao dados) {

  Sessao sessao = new Sessao();

  System.out.print(dados);

  sessao.setSala(dados.sala());
  sessao.setHorario(dados.horario());
  sessao.setPreco(dados.preco());

  return repositorySessao.save(sessao);
 }

 // GET ALL
 public List<Sessao> listarSessoes() {
  return repositorySessao.findAll();
 }

 // GET BY ID
 public Sessao buscarSessaoPorId(String id) {

  return repositorySessao.findById(id)
    .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
 }

 // PUT
 public Sessao atualizarSessao(String id, DTOPostSessao dados) {

  Sessao sessao = repositorySessao.findById(id)
    .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

  sessao.setSala(dados.sala());
  sessao.setHorario(dados.horario());
  sessao.setPreco(dados.preco());

  return repositorySessao.save(sessao);
 }

 // DELETE
 public void deletarSessao(String id) {

  Sessao sessao = repositorySessao.findById(id)
    .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

  repositorySessao.delete(sessao);
 }
}
