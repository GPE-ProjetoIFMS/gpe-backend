package com.br.gpe.service;

import com.br.gpe.dto.EspacoFisicoRequest;
import com.br.gpe.dto.EspacoFisicoResponse;
import com.br.gpe.infraestructure.entitys.EspacoFisico;
import com.br.gpe.infraestructure.repository.EspacoFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspacoFisicoService {

    private final EspacoFisicoRepository repository;

    @Transactional
    public EspacoFisicoResponse salvar(EspacoFisicoRequest dados) {
        EspacoFisico espaco = new EspacoFisico();
        espaco.setNome(dados.nome());
        espaco.setCapacidade(dados.capacidade());

        repository.save(espaco);
        return new EspacoFisicoResponse(espaco);
    }

    public EspacoFisicoResponse buscarPorId(Long id) {
        EspacoFisico espaco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espaço Físico não encontrado."));
        return new EspacoFisicoResponse(espaco);
    }

    public List<EspacoFisicoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(EspacoFisicoResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public EspacoFisicoResponse atualizar(Long id, EspacoFisicoRequest dados) {
        EspacoFisico espaco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espaço Físico não encontrado."));

        espaco.setNome(dados.nome());
        espaco.setCapacidade(dados.capacidade());

        repository.save(espaco);
        return new EspacoFisicoResponse(espaco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}