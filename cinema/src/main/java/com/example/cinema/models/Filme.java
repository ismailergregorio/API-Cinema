package com.example.cinema.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "filmes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
 @Id
 private String id;
 private String titulo;
 private String genero;
 private int duracao;
 private int clasificacao;
 private Boolean diponivel;
}
