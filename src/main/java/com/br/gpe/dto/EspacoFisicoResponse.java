package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.EspacoFisico;

public record EspacoFisicoResponse(
        Long id,
        String nome,
        Integer capacidade
) {
    public EspacoFisicoResponse(EspacoFisico espaco) {
        this(espaco.getId(), espaco.getNome(), espaco.getCapacidade());
    }
}