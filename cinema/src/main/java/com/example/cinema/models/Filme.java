package com.example.cinema.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "filmes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    private String id;
    private boolean adult;
    private String backdropPath;
    private List<Integer> genreIds;
    private String title;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private String releaseDate;
    private boolean softcore;
    private boolean video;
    private double voteAverage;
    private int voteCount;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
}
