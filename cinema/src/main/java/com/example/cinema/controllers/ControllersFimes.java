package com.example.cinema.controllers;

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

import com.example.cinema.DTO.DTOPostFilmes;
import com.example.cinema.models.Filme;
import com.example.cinema.services.ServicesFilme;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
public class ControllersFimes {

        @Autowired
        private ServicesFilme service;

        // ==================================================
        // CRIAR FILME
        // ==================================================

        @PostMapping
        @Operation(summary = "Criar filme")
        public ResponseEntity<Filme> createFilme(

                        @Valid @RequestBody DTOPostFilmes filme

        ) {

                Filme novoFilme = service.createFilmes(filme);

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(novoFilme);
        }

        // ==================================================
        // CRIAR LISTA DE FILMES
        // ==================================================

        @PostMapping("/lista")
        @Operation(summary = "Criar lista de filmes")
        public ResponseEntity<List<Filme>> createListaFilmes(

                        @RequestBody List<DTOPostFilmes> filmes

        ) {

                List<Filme> novosFilmes = service.createListaFilmes(filmes);

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(novosFilmes);
        }

        // ==================================================
        // LISTAR TODOS OS FILMES
        // ==================================================

        @GetMapping
        @Operation(summary = "Listar filmes")
        public ResponseEntity<List<Filme>> getFilmes() {

                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body(service.getFilmes());
        }

        // ==================================================
        // BUSCAR FILME POR ID
        // ==================================================

        @GetMapping("/{id}")
        @Operation(summary = "Buscar filme por ID")
        public ResponseEntity<?> getFilme(

                        @PathVariable String id

        ) {

                return service.getFilme(id);
        }

        // ==================================================
        // ATUALIZAR FILME
        // ==================================================

        @PutMapping("/{id}")
        @Operation(summary = "Atualizar filme")
        public ResponseEntity<?> updateFilme(

                        @PathVariable String id,

                        @Valid @RequestBody DTOPostFilmes filme

        ) {

                return service.updateFilme(id, filme);
        }

        // ==================================================
        // DELETAR FILME
        // ==================================================

        @DeleteMapping("/{id}")
        @Operation(summary = "Deletar filme")
        public ResponseEntity<?> deleteFilme(

                        @PathVariable String id

        ) {

                return service.deleteFilme(id);
        }

        @GetMapping("/categoria/{id}")
        @Operation(summary = "Listar filmes por categoria")
        public ResponseEntity<List<Filme>> listaFilmesCategorias(@PathVariable Integer id) {
                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body(service.listaFilmesCategorias(id));
        }

        @GetMapping("/nome/{nome}")
        @Operation(summary = "Buscar filmes por nome")
        public ResponseEntity<List<Filme>> buscaFilmesNome(

                        @PathVariable String nome

        ) {

                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body(service.BuscaFilmesNome(nome));
        }
}