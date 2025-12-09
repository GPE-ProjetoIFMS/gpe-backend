package com.br.gpe.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        super("Usuario não encontrado");
    }
    
}
