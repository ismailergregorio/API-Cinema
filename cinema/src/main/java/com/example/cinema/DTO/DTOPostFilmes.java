package com.example.cinema.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DTOPostFilmes(

  @NotBlank(message = "Título é obrigatório") String titulo,

  @NotBlank(message = "Gênero é obrigatório") String genero,

  @Positive(message = "Duração deve ser maior que 0") int duracao,

  @Positive(message = "Classificação deve ser maior que 0") int clasificacao,

  @NotNull(message = "Disponibilidade é obrigatória") Boolean diponivel

) {
}