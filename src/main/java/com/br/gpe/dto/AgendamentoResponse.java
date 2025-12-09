package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.Agendamento;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record AgendamentoResponse(
        Long id,
        LocalDate dataInicio,
        LocalDate dataFim,
        LocalDate dataFinal,
        ZonedDateTime horarioFinal,
        TurmaResponse turma,
        ResponsavelExternoResponse responsavelExterno,
        EspacoFisicoResponse espacoFisico
) {
    public AgendamentoResponse(Agendamento ag) {
        this(
            ag.getId(),
            ag.getDataInicio(),
            ag.getDataFim(),
            ag.getDataFinal(),
            ag.getHorarioFinal(),
            
            // CORREÇÃO AQUI: Verifica se é nulo antes de criar o DTO da Turma
            ag.getTurma() != null ? new TurmaResponse(ag.getTurma()) : null,
            
            // CORREÇÃO AQUI: Verifica se é nulo antes de criar o DTO do Responsável
            ag.getResponsavelExterno() != null ? new ResponsavelExternoResponse(ag.getResponsavelExterno()) : null,
            
            // Espaço físico é obrigatório, então não deve ser nulo
            new EspacoFisicoResponse(ag.getEspacoFisico())
        );
    }
}