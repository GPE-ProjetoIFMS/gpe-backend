package com.br.gpe.controller;


import com.br.gpe.business.ProfessorService;
import com.br.gpe.infraestructure.entitys.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor

public class ProfessorController {

    private final ProfessorService professorService;

@PostMapping
public ResponseEntity<Void> salvarProfessor(@RequestBody Professor professor) {
    professorService.salvarProfessor(professor);
    return ResponseEntity.ok().build();    
  
}

@GetMapping("/{cpf}")
public ResponseEntity<Professor> buscarProfessorPorCpf(@PathVariable String cpf) {
    return ResponseEntity.ok(professorService.buscarProfessorPorCpf(cpf));  


}

@DeleteMapping
public ResponseEntity<Void> deletarProfessorPorCpf(@RequestParam String cpf) {
    professorService.deletarProfessorPorCpf(cpf);
    return ResponseEntity.ok().build();         
}   

@PutMapping
public ResponseEntity<Void> atualizarProfessorPorId(@RequestParam Long id, @RequestBody Professor professor) {
    professorService.atualizarProfessorPorId(id, professor);
    return ResponseEntity.ok().build();         

}



}
