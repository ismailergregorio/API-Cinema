package com.example.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.services.ServicesCategoria;


@RestController
@RequestMapping("/categorias")
public class ControllersCategorias {
    @Autowired
    ServicesCategoria servicesCategoria;

    
}
