package com.br.gpe.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


/**
 * DTO (Data Transfer Object) para receber dados de criação e atualização de Modalidade.
 * Usamos as anotações do Bean Validation para garantir que os dados recebidos são válidos.
 */
public record ModalidadeRequest(

        @NotBlank(message = "O nome da modalidade não pode ser vazio.")
        @Size(min = 3, message = "O nome da modalidade deve ter no mínimo 3 caracteres.")
        String nome,

        @NotBlank(message = "O código não pode ser vazio.")
        @Size(min = 3, max = 10, message = "O código deve ter entre 3 e 10 caracteres.")
        String codigo
) {
}
