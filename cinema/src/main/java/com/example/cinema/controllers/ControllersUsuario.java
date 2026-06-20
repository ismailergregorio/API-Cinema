package com.example.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.DTO.DTOGetLoginUsuario;
import com.example.cinema.DTO.DTOGetUsuario;
import com.example.cinema.DTO.DTOPostUsuario;
import com.example.cinema.models.Usuario;
import com.example.cinema.repository.RepositoryUsuario;
import com.example.cinema.services.ServicesUsuario;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class ControllersUsuario {

   @Autowired
   ServicesUsuario servicesUsuario;

   @PostMapping()
   public DTOGetUsuario creteUser(@RequestBody DTOPostUsuario usuario) {
      return servicesUsuario.criaUsuario(usuario);
   }

   @PostMapping("/login")
   public ResponseEntity<DTOGetUsuario> login(@RequestBody DTOGetLoginUsuario dados) {

      System.out.println("Email: " + dados.email());
      System.out.println("Senha: " + dados.senha());

      return ResponseEntity.ok(servicesUsuario.loginUsuario(dados));
   }

   @GetMapping()
   public List<DTOGetUsuario> usuariosGet() {
      return servicesUsuario.buscarUsuarios();
   }

   @GetMapping("/all")
   public List<Usuario> todosUsuarios() {
      return servicesUsuario.users();
   }

}
