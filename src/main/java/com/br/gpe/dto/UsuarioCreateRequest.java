package com.br.gpe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateRequest {

    private String login;
    private String nome;
    private String email;

}
