package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.Aluno;
import java.time.LocalDate;

public record AlunoResponse(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String genero,
        String endereco,
        String telefone,
        String nomeResponsavel,
        String telefoneResponsavel
) {
    public AlunoResponse(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getDataNascimento(),
             aluno.getGenero(), aluno.getEndereco(), aluno.getTelefone(),
             aluno.getNomeResponsavel(), aluno.getTelefoneResponsavel());
    }
}