package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.Professor;
import java.time.LocalDate;

public record ProfessorResponse(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String endereco,
        String telefone
) {
    // Construtor para converter Entidade -> DTO
    public ProfessorResponse(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getCpf(),
             professor.getDataNascimento(), professor.getEndereco(), professor.getTelefone());
    }
}