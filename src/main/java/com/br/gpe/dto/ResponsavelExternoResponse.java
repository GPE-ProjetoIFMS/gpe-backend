package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import java.time.LocalDate;

public record ResponsavelExternoResponse(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String telefone
) {
    public ResponsavelExternoResponse(ResponsavelExterno resp) {
        this(resp.getId(), resp.getNome(), resp.getCpf(), resp.getDataNascimento(), resp.getTelefone());
    }
}