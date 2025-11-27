/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.gpe.security.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author 1513003
 */
public record LoginRequest(
        @NotBlank(message = "O username é obrigatório")
        String username,
        @NotBlank(message = "A senha é obrigatória")
        String password) {

}
