package com.br.gpe.business;

import org.springframework.stereotype.Service;
import com.br.gpe.infraestructure.entitys.EspacoFisico;
import com.br.gpe.infraestructure.repository.EspacoFisicoRepository;

@Service

public class EspacoFisicoService {

    private final EspacoFisicoRepository repository;

    public EspacoFisicoService(EspacoFisicoRepository repository) {
        this.repository = repository;
    }

    public void salvarEspacoFisico(EspacoFisico EspacoFisico) {
        repository.saveAndFlush(EspacoFisico);
    }

    public EspacoFisico buscarEspacoFisicoPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado."));
    }

    public void deletarEspacoFisicoPorId(Long id) {
        repository.deleteByCpf(id);
    }

    public void atualizarEspacoFisicoPorId(Long id, EspacoFisico EspacoFisico) {
        EspacoFisico EspacoFisicoEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("EspacoFisico não encontrado")));
        EspacoFisico EspacoFisicoAtualizado = EspacoFisico.builder()
                .id(EspacoFisico.getId() != null ? EspacoFisico.getId() : EspacoFisicoEntity.getId())
                .nome(EspacoFisico.getNome() != null ? EspacoFisico.getNome() : EspacoFisicoEntity.getNome())
                .id(EspacoFisicoEntity.getId())
                .build();
        repository.saveAndFlush(EspacoFisicoAtualizado);

    }

}
