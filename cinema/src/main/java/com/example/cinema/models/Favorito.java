package com.example.cinema.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "favoritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndex(def = "{'usuarioId':1,'filmeId':1}", unique = true)
public class Favorito {
 @Id
 private String id;
 private String filmeId;
 private String usuarioId;
 @CreatedDate
 private LocalDateTime dataCriacao;

 @LastModifiedDate
 private LocalDateTime dataAtualizacao;
}
