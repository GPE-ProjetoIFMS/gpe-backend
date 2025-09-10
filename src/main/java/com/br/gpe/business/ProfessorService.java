package com.br.gpe.business;

import org.springframework.stereotype.Service;
import com.br.gpe.infraestructure.entitys.Professor;
import com.br.gpe.infraestructure.repository.ProfessorRepository;

@Service

public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public void salvarProfessor(Professor professor) {
        repository.saveAndFlush(professor);
    }

    public Professor buscarProfessorPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("Cpf não encontrado."));
    }

    public void deletarProfessorPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }

    public void atualizarProfessorPorId(Long id, Professor professor) {
        Professor professorEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Professor não encontrado")));
        Professor professorAtualizado = Professor.builder()
                .cpf(professor.getCpf() != null ? professor.getCpf() : professorEntity.getCpf())
                .nome(professor.getNome() != null ? professor.getNome() : professorEntity.getNome())
                .id(professorEntity.getId())
                .build();
        repository.saveAndFlush(professorAtualizado);

    }

}
