package com.example.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.DTO.DTOGetUsuario;
import com.example.cinema.DTO.DTOPostUsuario;
import com.example.cinema.repository.RepositoryUsuario;
import com.example.cinema.services.ServicesUsuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class ControllersUsuario {

 @Autowired
 ServicesUsuario servicesUsuario;

 @PostMapping()
 public DTOGetUsuario creteUser(@RequestBody DTOPostUsuario usuario) {
  return servicesUsuario.criaUsuario(usuario);
 }
}
