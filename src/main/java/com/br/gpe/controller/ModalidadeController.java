package com.br.gpe.controller;

import com.br.gpe.business.ModalidadeService;
import com.br.gpe.infraestructure.entitys.Modalidade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modalidade")
@RequiredArgsConstructor

public class ModalidadeController {

    private final ModalidadeService ModalidadeService;

    @PostMapping
    public ResponseEntity<Void> salvarModalidade(@RequestBody Modalidade modalidade){
        ModalidadeService.salvarModalidade(modalidade);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Modalidade> buscarModalidadePorId(@PathVariable Long id){
        return ResponseEntity.ok(ModalidadeService.buscarModalidadePorId(id));
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
