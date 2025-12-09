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
public class UsuarioRegisterRequest {

    private String login;
    private String senha;
    private String nome;
    private String email;

}
