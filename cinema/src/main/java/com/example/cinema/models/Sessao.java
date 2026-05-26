package com.example.cinema.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "sessao")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
 @Id
 private String id;
 private String sala;
 private String horario;
 private Float preco;
 @CreatedDate
 private LocalDateTime dataCriacao;

 @LastModifiedDate
 private LocalDateTime dataAtualizacao;
}
