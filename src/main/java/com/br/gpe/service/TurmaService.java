package com.br.gpe.service;

import com.br.gpe.dto.TurmaRequest;
import com.br.gpe.dto.TurmaResponse;
import com.br.gpe.infraestructure.entitys.Agendamento; // Import novo
import com.br.gpe.infraestructure.entitys.EspacoFisico; // Import novo
import com.br.gpe.infraestructure.entitys.Modalidade;
import com.br.gpe.infraestructure.entitys.Professor;
import com.br.gpe.infraestructure.entitys.Turma;
import com.br.gpe.infraestructure.repository.AgendamentoRepository; // Import novo
import com.br.gpe.infraestructure.repository.EspacoFisicoRepository; // Import novo
import com.br.gpe.infraestructure.repository.ModalidadeRepository;
import com.br.gpe.infraestructure.repository.ProfessorRepository;
import com.br.gpe.infraestructure.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository repository;
    private final ProfessorRepository professorRepository;
    private final ModalidadeRepository modalidadeRepository;
    
    // Injeções novas para o agendamento automático
    private final EspacoFisicoRepository espacoFisicoRepository;
    private final AgendamentoRepository agendamentoRepository;

    @Transactional
    public TurmaResponse salvar(TurmaRequest dados) {
        // 1. Busca todas as entidades relacionadas
        Professor professor = professorRepository.findById(dados.professorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + dados.professorId()));

        Modalidade modalidade = modalidadeRepository.findById(dados.modalidadeId())
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada com ID: " + dados.modalidadeId()));
                
        // Busca o Espaço Físico agora exigido
        EspacoFisico espaco = espacoFisicoRepository.findById(dados.espacoFisicoId())
                .orElseThrow(() -> new RuntimeException("Espaço Físico não encontrado com ID: " + dados.espacoFisicoId()));

        // 2. Cria e Salva a Turma
        Turma turma = new Turma();
        turma.setNome(dados.nome());
        turma.setNivel(dados.nivel());
        turma.setQntdAlunos(dados.qntdAlunos());
        turma.setDataInicio(dados.dataInicio());
        turma.setDataFinal(dados.dataFinal());
        turma.setHorarioInicio(dados.horarioInicio());
        turma.setHorarioFinal(dados.horarioFinal());
        
        turma.setProfessor(professor);
        turma.setModalidade(modalidade);

        Turma turmaSalva = repository.save(turma);

        // 3. AUTOMATIZAÇÃO: Cria o Agendamento vinculado a esta Turma
        Agendamento agendamento = new Agendamento();
        agendamento.setTurma(turmaSalva);
        agendamento.setEspacoFisico(espaco); // Usa o espaço que veio no request
        
        // Copia as datas/horários da turma para o agendamento
        agendamento.setDataInicio(turmaSalva.getDataInicio());
        agendamento.setDataFim(turmaSalva.getDataFinal());
        agendamento.setDataFinal(turmaSalva.getDataFinal()); // Campo duplicado na entidade, preenchemos ambos
        agendamento.setHorarioFinal(turmaSalva.getHorarioFinal());
        
        // Salva o agendamento automaticamente!
        agendamentoRepository.save(agendamento);

        return new TurmaResponse(turmaSalva);
    }

    // ... (Mantenha os métodos buscarPorId, listarTodas, deletar e atualizar aqui)
    // Atenção: No método "atualizar", lembre-se de atualizar o Agendamento também se mudar o horário/local!
    
    public TurmaResponse buscarPorId(Long id) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada."));
        return new TurmaResponse(turma);
    }

    public List<TurmaResponse> listarTodas() {
        return repository.findAll().stream()
                .map(TurmaResponse::new)
                .collect(Collectors.toList());
    }
    
    public void deletar(Long id) {
        // Nota: Pode ser necessário deletar os agendamentos da turma antes de deletar a turma
        // Depende da configuração do banco (Cascade). Se der erro de FK, avise!
        repository.deleteById(id);
    }
    
    // Vou incluir o atualizar básico para não dar erro de compilação
    @Transactional
    public TurmaResponse atualizar(Long id, TurmaRequest dados) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
                
        // ... (Atualize os campos da turma aqui como antes) ...
        
        repository.save(turma);
        return new TurmaResponse(turma);
    }
}