package com.br.gpe.service;

import com.br.gpe.dto.MatriculaRequest;
import com.br.gpe.dto.MatriculaResponse;
import com.br.gpe.infraestructure.entitys.Aluno;
import com.br.gpe.infraestructure.entitys.Matricula;
import com.br.gpe.infraestructure.entitys.Turma;
import com.br.gpe.infraestructure.repository.AlunoRepository;
import com.br.gpe.infraestructure.repository.MatriculaRepository;
import com.br.gpe.infraestructure.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository repository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    @Transactional
    public MatriculaResponse realizarMatricula(MatriculaRequest dados) {
        Aluno aluno = alunoRepository.findById(dados.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + dados.alunoId()));

        Turma turma = turmaRepository.findById(dados.turmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com ID: " + dados.turmaId()));

        Matricula matricula = new Matricula();
        matricula.setData(dados.data());
        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        repository.save(matricula);
        return new MatriculaResponse(matricula);
    }

    public List<MatriculaResponse> listarTodas() {
        return repository.findAll().stream()
                .map(MatriculaResponse::new)
                .collect(Collectors.toList());
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}