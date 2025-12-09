package com.br.gpe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EspacoFisicoRequest(
        @NotBlank(message = "O nome do espaço é obrigatório") String nome,
        @NotNull(message = "A capacidade é obrigatória") Integer capacidade
) {}