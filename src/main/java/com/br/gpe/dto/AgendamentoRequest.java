package com.br.gpe.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record AgendamentoRequest(
        @NotNull LocalDate dataInicio,
        @NotNull LocalDate dataFim,
        @NotNull LocalDate dataFinal,
        @NotNull ZonedDateTime horarioFinal,
        
        @NotNull Long turmaId,
        @NotNull Long responsavelExternoId,
        @NotNull Long espacoFisicoId
) {}