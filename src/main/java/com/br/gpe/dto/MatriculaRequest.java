package com.br.gpe.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record MatriculaRequest(
        @NotNull(message = "A data da matrícula é obrigatória")
        LocalDate data,

        @NotNull(message = "O aluno é obrigatório")
        Long alunoId,

        @NotNull(message = "A turma é obrigatória")
        Long turmaId
) {}
