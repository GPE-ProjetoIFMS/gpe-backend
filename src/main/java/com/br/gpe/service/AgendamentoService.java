package com.br.gpe.service;

import com.br.gpe.dto.AgendamentoRequest;
import com.br.gpe.dto.AgendamentoResponse;
import com.br.gpe.infraestructure.entitys.Agendamento;
import com.br.gpe.infraestructure.entitys.EspacoFisico;
import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import com.br.gpe.infraestructure.entitys.Turma;
import com.br.gpe.infraestructure.repository.AgendamentoRepository;
import com.br.gpe.infraestructure.repository.EspacoFisicoRepository;
import com.br.gpe.infraestructure.repository.ResponsavelExternoRepository;
import com.br.gpe.infraestructure.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final TurmaRepository turmaRepository;
    private final ResponsavelExternoRepository responsavelRepository;
    private final EspacoFisicoRepository espacoRepository;

    @Transactional
    public AgendamentoResponse salvar(AgendamentoRequest dados) {
        Turma turma = turmaRepository.findById(dados.turmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        
        ResponsavelExterno responsavel = responsavelRepository.findById(dados.responsavelExternoId())
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
                
        EspacoFisico espaco = espacoRepository.findById(dados.espacoFisicoId())
                .orElseThrow(() -> new RuntimeException("Espaço Físico não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setDataInicio(dados.dataInicio());
        agendamento.setDataFim(dados.dataFim());
        agendamento.setDataFinal(dados.dataFinal());
        agendamento.setHorarioFinal(dados.horarioFinal());
        
        agendamento.setTurma(turma);
        agendamento.setResponsavelExterno(responsavel);
        agendamento.setEspacoFisico(espaco);

        repository.save(agendamento);
        return new AgendamentoResponse(agendamento);
    }

    public List<AgendamentoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(AgendamentoResponse::new)
                .collect(Collectors.toList());
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}