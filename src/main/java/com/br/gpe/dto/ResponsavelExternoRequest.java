package com.br.gpe.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record ResponsavelExternoRequest(
        @NotBlank String nome,
        @NotBlank String cpf,
        LocalDate dataNascimento,
        String telefone
) {}