package com.br.gpe.dto;

import com.br.gpe.enumeration.NivelHabilidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record TurmaRequest(
        @NotBlank(message = "O nome da turma é obrigatório")
        String nome,

        @NotNull(message = "A modalidade é obrigatória")
        Long modalidadeId,

        @NotNull(message = "O professor é obrigatório")
        Long professorId,
        
        // NOVO CAMPO: Precisamos saber onde será a aula para agendar!
        @NotNull(message = "O espaço físico é obrigatório")
        Long espacoFisicoId,

        @NotNull(message = "O nível é obrigatório")
        NivelHabilidade nivel,

        Integer qntdAlunos,
        LocalDate dataInicio,
        LocalDate dataFinal,
        ZonedDateTime horarioInicio,
        ZonedDateTime horarioFinal
) {}