package com.br.gpe.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record ProfessorRequest(
        @NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O CPF é obrigatório") String cpf,
        LocalDate dataNascimento,
        String endereco,
        String telefone
) {}