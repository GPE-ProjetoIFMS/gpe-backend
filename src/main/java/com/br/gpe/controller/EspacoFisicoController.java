package com.br.gpe.controller;

import com.br.gpe.dto.EspacoFisicoRequest;
import com.br.gpe.dto.EspacoFisicoResponse;
import com.br.gpe.service.EspacoFisicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/espaco-fisico")
@RequiredArgsConstructor
public class EspacoFisicoController {

    private final EspacoFisicoService service;

    @PostMapping
    public ResponseEntity<EspacoFisicoResponse> salvar(@RequestBody @Valid EspacoFisicoRequest dados) {
        EspacoFisicoResponse salvo = service.salvar(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<EspacoFisicoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacoFisicoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspacoFisicoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid EspacoFisicoRequest dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}