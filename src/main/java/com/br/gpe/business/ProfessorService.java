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

    public Professor buscarProfessorPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado."));
    }

    public Professor buscarProfessorPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado."));
    }

    public void deletarProfessorPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }

    public void atualizarProfessorPorId(Long id, Professor professor) {
        Professor professorEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Professor não encontrado")));
    // 2. Atualiza os campos DA ENTIDADE BUSCADA
        if (professor.getCpf() != null) {
            professorEntity.setCpf(professor.getCpf());
        }
        if (professor.getNome() != null) {
            professorEntity.setNome(professor.getNome());
        }

        if (professor.getDataNascimento() != null) {
            professorEntity.setDataNascimento(professor.getDataNascimento());
        }
        if (professor.getEndereco() != null) {
            professorEntity.setEndereco(professor.getEndereco());
        }
        if (professor.getTelefone() != null) {
            professorEntity.setTelefone(professor.getTelefone());
        }

        
        // 3. Salva a entidade que foi modificada
        repository.save(professorEntity);
                
    }

}
