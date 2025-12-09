package com.br.gpe.controller;

import com.br.gpe.dto.ProfessorRequest;
import com.br.gpe.dto.ProfessorResponse;
import com.br.gpe.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponse> salvar(@RequestBody @Valid ProfessorRequest dados) {
        ProfessorResponse salvo = service.salvar(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ProfessorRequest dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}