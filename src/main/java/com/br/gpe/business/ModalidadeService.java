package com.br.gpe.business;

import org.springframework.stereotype.Service;
import com.br.gpe.infraestructure.entitys.Modalidade;
import com.br.gpe.infraestructure.repository.ModalidadeRepository;


@Service

public class ModalidadeService {

    private final ModalidadeRepository repository;

    public ModalidadeService(ModalidadeRepository repository) {
        this.repository = repository;
    }

    public void salvarModalidade(Modalidade modalidade) {
        repository.saveAndFlush(modalidade);
    }

   public Modalidade buscarModalidadePorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado."));
    }

   public Modalidade buscarModalidadePorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado."));
    }

    public void deletarModalidadePorId(Long id) {
        repository.deleteById(id);
    }

    public void atualizarModalidadePorId(Long id, Modalidade modalidade) {
        Modalidade ModalidadeEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Modalidade não encontrado")));
        Modalidade modalidadeAtualizado = Modalidade.builder()
                .id(modalidade.getId() != null ? modalidade.getId() : ModalidadeEntity.getId())
                .nome(modalidade.getNome() != null ? modalidade.getNome() : ModalidadeEntity.getNome())
                .id(ModalidadeEntity.getId())
                .build();
        repository.saveAndFlush(modalidadeAtualizado);

    }

}

