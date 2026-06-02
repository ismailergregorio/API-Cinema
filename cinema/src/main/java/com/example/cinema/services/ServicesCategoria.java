package com.example.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.models.Categorias;
import com.example.cinema.repository.RepositoryCategorias;
@Service
public class ServicesCategoria {
    @Autowired
    private RepositoryCategorias repository;

    public Categorias createCategoria(Categorias categoria) {
        return repository.save(categoria);
    }

    public List<Categorias> createListaCategorias(List<Categorias> categorias) {
        return repository.saveAll(categorias);
    }

    public List<Categorias> getCategorias() {
        return repository.findAll();
    }  
    
    public Categorias getCategoriaById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Categorias updateCategoria(String id, Categorias categoria) {
        Categorias existingCategoria = repository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setName(categoria.getName());
            return repository.save(existingCategoria);
        }
        return null;
    }

    public void deleteCategoria(String id) {
        repository.deleteById(id);
    }
}
