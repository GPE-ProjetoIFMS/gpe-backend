package com.br.gpe.dto;

import com.br.gpe.infraestructure.entitys.Modalidade;

/**
 * DTO para enviar os dados de uma Modalidade para o cliente.
 * Este DTO representa a "visão pública" da nossa entidade.
 */
public record ModalidadeResponse(
        Long id, // Ou UUID, dependendo do tipo do seu ID
        String nome,
        String codigo) {
    /**
     * Construtor adicional que facilita a conversão de uma Entidade para este DTO.
     */
    public ModalidadeResponse(Modalidade modalidade) {
        this(modalidade.getId(), modalidade.getNome(), modalidade.getCodigo());
    }
}
