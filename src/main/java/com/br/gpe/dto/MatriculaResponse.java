package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.Matricula;
import java.time.LocalDate;

public record MatriculaResponse(
        Long id,
        LocalDate data,
        AlunoResponse aluno, // Retorna o objeto completo
        TurmaResponse turma  // Retorna o objeto completo
) {
    public MatriculaResponse(Matricula matricula) {
        this(
            matricula.getId(),
            matricula.getData(),
            new AlunoResponse(matricula.getAluno()),
            new TurmaResponse(matricula.getTurma())
        );
    }
}
