package com.br.gpe.controller;

import com.br.gpe.dto.ResponsavelExternoRequest;
import com.br.gpe.dto.ResponsavelExternoResponse;
import com.br.gpe.service.ResponsavelExternoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/responsavel-externo")
@RequiredArgsConstructor
public class ResponsavelExternoController {

    private final ResponsavelExternoService service;

    @PostMapping
    public ResponseEntity<ResponsavelExternoResponse> salvar(@RequestBody @Valid ResponsavelExternoRequest dados) {
        ResponsavelExternoResponse salvo = service.salvar(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelExternoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelExternoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelExternoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ResponsavelExternoRequest dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}