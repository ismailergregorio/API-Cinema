package com.example.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
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

import com.example.cinema.models.Categorias;
import com.example.cinema.services.ServicesCategoria;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class ControllersCategorias {
    @Autowired
    ServicesCategoria service;

    // Criar uma categoria
    @PostMapping
    public ResponseEntity<Categorias> createCategoria(@RequestBody Categorias categoria) {
        return ResponseEntity.ok(service.createCategoria(categoria));
    }

    // Criar várias categorias
    @PostMapping("/lista")
    public ResponseEntity<List<Categorias>> createListaCategorias(
            @RequestBody List<Categorias> categorias) {
        return ResponseEntity.ok(service.createListaCategorias(categorias));
    }

    // Buscar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categorias>> getCategorias() {
        return ResponseEntity.ok(service.getCategorias());
    }

    // Buscar categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriaById(@PathVariable String id) {
        Categorias categoria = service.getCategoriaById(id);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    // Atualizar categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categorias> updateCategoria(
            @PathVariable String id,
            @RequestBody Categorias categoria) {

        Categorias updatedCategoria = service.updateCategoria(id, categoria);

        if (updatedCategoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCategoria);
    }

    // Deletar categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable String id) {
        service.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
