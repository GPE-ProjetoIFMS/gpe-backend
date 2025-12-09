package com.br.gpe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author 1513003
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DefaultRequest {
    
    @NotNull(message = "O campo NOME deve ser informado!")
    @NotEmpty(message = "O campo NOME não deve estar vazio!")
    @NotBlank(message = "O campo NOME não deve conter somente ESPAÇO VAZIO!")
    @Size(min = 1, max = 255, message = "Limite de caracteres para o campo NOME.")
    private String nome;
    
}