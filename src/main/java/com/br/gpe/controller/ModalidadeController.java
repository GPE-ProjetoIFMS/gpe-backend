package com.br.gpe.controller;

import com.br.gpe.business.ModalidadeService;
import com.br.gpe.dto.ModalidadeRequestDTO;
import com.br.gpe.dto.ModalidadeResponseDTO;
import com.br.gpe.infraestructure.entitys.Modalidade;

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
    public ResponseEntity<ModalidadeResponseDTO> salvarModalidade(@RequestBody @Valid ModalidadeRequestDTO dados){
       // Recebe o DTO de requisição
        ModalidadeResponseDTO novaModalidade = ModalidadeService.criarModalidade(dados);
       // Devolve o DTO de resposta
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaModalidade.id()).toUri();
        return ResponseEntity.created(uri).body(novaModalidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalidadeResponseDTO> buscarModalidadePorId(@PathVariable Long id) {
        ModalidadeResponseDTO modalidade = ModalidadeService.buscarModalidadePorId(id);
        return ResponseEntity.ok(modalidade);
    }

    @GetMapping("/{modalidadeNome}")
    public ResponseEntity <Modalidade> buscarModalidadePorNome(@PathVariable String nome){
        return ResponseEntity.ok(ModalidadeService.buscarModalidadePorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarModalidadePorId(@RequestParam Long id){
       ModalidadeService.deletarModalidadePorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
public ResponseEntity<Void> atualizarModalidadePorId(@RequestParam Long id ,@RequestBody Modalidade modalidade){
        ModalidadeService.atualizarModalidadePorId(id,modalidade);
        return ResponseEntity.ok().build();
    }

}
