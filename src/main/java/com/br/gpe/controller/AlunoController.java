package com.br.gpe.controller;

import com.br.gpe.dto.AlunoRequest;
import com.br.gpe.dto.AlunoResponse;
import com.br.gpe.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponse> salvarAluno(@RequestBody @Valid AlunoRequest dados) {
        AlunoResponse alunoSalvo = alunoService.salvarAluno(dados);
        
        // Cria a URL para o novo recurso criado (Boas práticas REST)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(alunoSalvo.id())
                .toUri();
                
        return ResponseEntity.created(uri).body(alunoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscarAlunoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizarAlunoPorId(@PathVariable Long id, @RequestBody @Valid AlunoRequest dados) {
        return ResponseEntity.ok(alunoService.atualizarAlunoPorId(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }
    
    // Endpoint extra para buscar por CPF
    @GetMapping("/busca-cpf/{cpf}")
    public ResponseEntity<AlunoResponse> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(alunoService.buscarAlunoPorCpf(cpf));
    }
}