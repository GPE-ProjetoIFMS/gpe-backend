package com.br.gpe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public abstract class DefaultResponse {
    
    private Long id;
    private String nome;
    
}
