package com.br.gpe.controller;

import com.br.gpe.dto.MatriculaRequest;
import com.br.gpe.dto.MatriculaResponse;
import com.br.gpe.service.MatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService service;

    @PostMapping
    public ResponseEntity<MatriculaResponse> matricular(@RequestBody @Valid MatriculaRequest dados) {
        MatriculaResponse salva = service.realizarMatricula(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salva.id()).toUri();
        return ResponseEntity.created(uri).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponse>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}