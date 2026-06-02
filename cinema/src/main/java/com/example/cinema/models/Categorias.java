package com.example.cinema.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "categorias")

public class Categorias {
    private String id;
    private String name;
}
