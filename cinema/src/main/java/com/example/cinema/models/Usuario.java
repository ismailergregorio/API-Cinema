package com.example.cinema.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
 @Id
 private String id;
 private String nome;
 private String email;
 private String senha;
 @CreatedDate
 private LocalDateTime dataCriacao;

 @LastModifiedDate
 private LocalDateTime dataAtualizacao;
}
