package com.br.gpe.controller;

import com.br.gpe.dto.AgendamentoRequest;
import com.br.gpe.dto.AgendamentoResponse;
import com.br.gpe.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criar(@RequestBody @Valid AgendamentoRequest dados) {
        AgendamentoResponse salvo = service.salvar(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}