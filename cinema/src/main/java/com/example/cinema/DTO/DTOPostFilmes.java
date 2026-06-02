package com.example.cinema.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DTOPostFilmes(

        Boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        String title,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        String overview,

        Double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("release_date")
        String releaseDate,

        Boolean softcore,

        Boolean video,

        @JsonProperty("vote_average")
        Double voteAverage,

        @JsonProperty("vote_count")
        Integer voteCount

) {
}