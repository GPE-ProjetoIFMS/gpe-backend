package com.br.gpe.controller;

import com.br.gpe.dto.ModalidadeRequest;
import com.br.gpe.dto.ModalidadeResponse;
import com.br.gpe.infraestructure.entitys.Modalidade;
import com.br.gpe.service.ModalidadeService;
import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/modalidades")
@RequiredArgsConstructor

public class ModalidadeController {

    private final ModalidadeService ModalidadeService;

    @PostMapping
    public ResponseEntity<ModalidadeResponse> salvarModalidade(@RequestBody @Valid ModalidadeRequest dados) {
        // Recebe o DTO de requisição
        ModalidadeResponse novaModalidade = ModalidadeService.criarModalidade(dados);
        // Devolve o DTO de resposta
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaModalidade.id()).toUri();
        return ResponseEntity.created(uri).body(novaModalidade);
    }

    @GetMapping
    public ResponseEntity<List<ModalidadeResponse>> listarTodas() {
        return ResponseEntity.ok(ModalidadeService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalidadeResponse> buscarModalidadePorId(@PathVariable Long id) {
        // Esta linha espera um ModalidadeResponseDTO
        ModalidadeResponse modalidade = ModalidadeService.buscarModalidadePorId(id);
        return ResponseEntity.ok(modalidade);
    }

    @GetMapping("/{modalidadeNome}")
    public ResponseEntity<Modalidade> buscarModalidadePorNome(@PathVariable String nome) {
        return ResponseEntity.ok(ModalidadeService.buscarModalidadePorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarModalidadePorId(@RequestParam Long id) {
        ModalidadeService.deletarModalidadePorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarModalidadePorId(@RequestParam Long id, @RequestBody Modalidade modalidade) {
        ModalidadeService.atualizarModalidadePorId(id, modalidade);
        return ResponseEntity.ok().build();
    }

}
