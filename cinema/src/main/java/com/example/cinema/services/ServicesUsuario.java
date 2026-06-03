package com.example.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.cinema.DTO.DTOGetLoginUsuario;
import com.example.cinema.DTO.DTOGetUsuario;
import com.example.cinema.DTO.DTOPostUsuario;
import com.example.cinema.models.Usuario;
import com.example.cinema.repository.RepositoryUsuario;

@Service
public class ServicesUsuario {
 @Autowired
 RepositoryUsuario repositoryUsuario;

 public DTOGetUsuario criaUsuario(DTOPostUsuario dados) {
  if (repositoryUsuario.findByEmail(dados.email()).isPresent()) {
   throw new RuntimeException("Usuario já existe com este email!");
  }
  Usuario novoUsuario = new Usuario();

  novoUsuario.setNome(dados.nome());
  novoUsuario.setEmail(dados.email());
  novoUsuario.setSenha(dados.senha());

  repositoryUsuario.save(novoUsuario);

  return new DTOGetUsuario(
    novoUsuario.getId(),
    novoUsuario.getNome(),
    novoUsuario.getEmail());
 }

 public DTOGetUsuario loginUsuario(DTOGetLoginUsuario dados) {
  System.out.println("Email: " + dados.email());
  System.out.println("Senha: " + dados.senha());
  Usuario usuario = repositoryUsuario.findByEmail(dados.email())
    .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

  if (!usuario.getSenha().equals(dados.senha())) {
   throw new RuntimeException("Senha incorreta!");
  }

  return new DTOGetUsuario(
    usuario.getId(),
    usuario.getNome(),
    usuario.getEmail());
 }

}
