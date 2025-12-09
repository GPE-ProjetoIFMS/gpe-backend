package com.br.gpe.service;

import com.br.gpe.dto.ProfessorRequest;
import com.br.gpe.dto.ProfessorResponse;
import com.br.gpe.infraestructure.entitys.Professor;
import com.br.gpe.infraestructure.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;

    @Transactional
    public ProfessorResponse salvar(ProfessorRequest dados) {
        Professor professor = new Professor();
        professor.setNome(dados.nome());
        professor.setCpf(dados.cpf());
        professor.setDataNascimento(dados.dataNascimento());
        professor.setEndereco(dados.endereco());
        professor.setTelefone(dados.telefone());

        repository.save(professor);
        return new ProfessorResponse(professor);
    }

    public ProfessorResponse buscarPorId(Long id) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado."));
        return new ProfessorResponse(professor);
    }

    public List<ProfessorResponse> listarTodos() {
        return repository.findAll().stream()
                .map(ProfessorResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProfessorResponse atualizar(Long id, ProfessorRequest dados) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setNome(dados.nome());
        professor.setCpf(dados.cpf());
        professor.setDataNascimento(dados.dataNascimento());
        professor.setEndereco(dados.endereco());
        professor.setTelefone(dados.telefone());

        repository.save(professor);
        return new ProfessorResponse(professor);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}