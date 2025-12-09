package com.br.gpe.dto;

import com.br.gpe.enumeration.NivelHabilidade;
import com.br.gpe.infraestructure.entitys.Turma;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record TurmaResponse(
        Long id,
        String nome,
        ModalidadeResponse modalidade, // Já aninha o DTO completo para leitura
        ProfessorResponse professor,   // Já aninha o DTO completo para leitura
        NivelHabilidade nivel,
        Integer qntdAlunos,
        LocalDate dataInicio,
        LocalDate dataFinal,
        ZonedDateTime horarioInicio,
        ZonedDateTime horarioFinal
) {
    public TurmaResponse(Turma turma) {
        this(
            turma.getId(),
            turma.getNome(),
            new ModalidadeResponse(turma.getModalidade()), // Converte a modalidade
            new ProfessorResponse(turma.getProfessor()),   // Converte o professor
            turma.getNivel(),
            turma.getQntdAlunos(),
            turma.getDataInicio(),
            turma.getDataFinal(),
            turma.getHorarioInicio(),
            turma.getHorarioFinal()
        );
    }
}