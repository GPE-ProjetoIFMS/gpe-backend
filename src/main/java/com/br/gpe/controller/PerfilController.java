package com.br.gpe.controller;

import com.br.gpe.infraestructure.entitys.Perfil;
// Certifique-se que o pacote do Service abaixo bate com onde você salvou o Passo 3
import com.br.gpe.service.PerfilService; 
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService service;

    @PostMapping
    public ResponseEntity<Perfil> salvar(@RequestBody Perfil perfil) {
        return ResponseEntity.ok(service.salvar(perfil));
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
}