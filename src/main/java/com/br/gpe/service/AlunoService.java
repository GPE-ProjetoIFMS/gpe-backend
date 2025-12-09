package com.br.gpe.service;

import com.br.gpe.dto.AlunoRequest;
import com.br.gpe.dto.AlunoResponse;
import com.br.gpe.infraestructure.entitys.Aluno;
import com.br.gpe.infraestructure.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    @Transactional
    public AlunoResponse salvarAluno(AlunoRequest dados) {
        // 1. Converte DTO -> Entidade
        Aluno aluno = new Aluno();
        aluno.setNome(dados.nome());
        aluno.setCpf(dados.cpf());
        aluno.setDataNascimento(dados.dataNascimento());
        aluno.setGenero(dados.genero());
        aluno.setEndereco(dados.endereco());
        aluno.setTelefone(dados.telefone());
        aluno.setNomeResponsavel(dados.nomeResponsavel());
        aluno.setTelefoneResponsavel(dados.telefoneResponsavel());

        // 2. Salva
        repository.save(aluno);

        // 3. Retorna DTO Response
        return new AlunoResponse(aluno);
    }

    public AlunoResponse buscarAlunoPorId(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
        return new AlunoResponse(aluno);
    }

    public List<AlunoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(AlunoResponse::new) // Converte cada Aluno da lista para AlunoResponse
                .collect(Collectors.toList());
    }

    @Transactional
    public AlunoResponse atualizarAlunoPorId(Long id, AlunoRequest dados) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Atualiza os campos
        aluno.setNome(dados.nome());
        aluno.setCpf(dados.cpf());
        aluno.setDataNascimento(dados.dataNascimento());
        aluno.setGenero(dados.genero());
        aluno.setEndereco(dados.endereco());
        aluno.setTelefone(dados.telefone());
        aluno.setNomeResponsavel(dados.nomeResponsavel());
        aluno.setTelefoneResponsavel(dados.telefoneResponsavel());

        repository.save(aluno);
        return new AlunoResponse(aluno);
    }

    public void deletarAlunoPorId(Long id) {
        repository.deleteById(id); // Alterei para deleteById que é mais seguro pelo ID
    }
    
    // Mantive este método auxiliar caso precise, mas agora retornando DTO
    public AlunoResponse buscarAlunoPorCpf(String cpf) {
         Aluno aluno = repository.findByCpf(cpf)
                 .orElseThrow(() -> new RuntimeException("CPF não encontrado."));
         return new AlunoResponse(aluno);
    }
}