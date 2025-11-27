package com.br.gpe.controller;

import com.br.gpe.infraestructure.entitys.EspacoFisico;
import com.br.gpe.service.EspacoFisicoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/espaco-fisico")
@RequiredArgsConstructor

public class EspacoFisicoController {

    private final EspacoFisicoService espacoFisicoService;

    @PostMapping
    public ResponseEntity<Void> salvarEspacoFisico(@RequestBody EspacoFisico espacoFisico){
        espacoFisicoService.salvarEspacoFisico(espacoFisico);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <EspacoFisico> buscarEspacoFisicoPorId(@PathVariable Long id){
        return ResponseEntity.ok(espacoFisicoService.buscarEspacoFisicoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEspacoFisicoPorId(@RequestParam Long id){
       espacoFisicoService.deletarEspacoFisicoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
public ResponseEntity<Void> atualizarEspacoFisicoPorId(@RequestParam Long id ,@RequestBody EspacoFisico espacoFisico){
        espacoFisicoService.atualizarEspacoFisicoPorId(id,espacoFisico);
        return ResponseEntity.ok().build();
    }

}

