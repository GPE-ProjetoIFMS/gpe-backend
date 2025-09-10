package com.br.gpe.controller;

import com.br.gpe.business.ResponsavelExternoService;
import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsavelExterno")
@RequiredArgsConstructor

public class ResponsavelExternoController {

    private final ResponsavelExternoService responsavelExternoService;

    @PostMapping
    public ResponseEntity<Void> salvarResponsavelExterno(@RequestBody ResponsavelExterno responsavelExterno){
        responsavelExternoService.salvarResponsavelExterno(responsavelExterno);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity <ResponsavelExterno> buscarResponsavelExternoPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(responsavelExternoService.buscarResponsavelExternoPorCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarResponsavelExternoPorCpf(@RequestParam String cpf){
       responsavelExternoService.deletarResponsavelExternoPorCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping
public ResponseEntity<Void> atualizarResponsavelExternoPorId(@RequestParam Long id ,@RequestBody ResponsavelExterno responsavelExterno){
        responsavelExternoService.atualizarResponsavelExternoPorId(id,responsavelExterno);
        return ResponseEntity.ok().build();
    }

}

