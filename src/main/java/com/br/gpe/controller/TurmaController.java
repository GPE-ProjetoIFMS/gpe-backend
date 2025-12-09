package com.br.gpe.controller;

import com.br.gpe.dto.TurmaRequest;
import com.br.gpe.dto.TurmaResponse;
import com.br.gpe.service.TurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService service;

    @PostMapping
    public ResponseEntity<TurmaResponse> salvar(@RequestBody @Valid TurmaRequest dados) {
        TurmaResponse turmaSalva = service.salvar(dados);
        
        // Cria a URI para o novo recurso (Boas práticas REST)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(turmaSalva.id())
                .toUri();
                
        return ResponseEntity.created(uri).body(turmaSalva);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid TurmaRequest dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }
    
}