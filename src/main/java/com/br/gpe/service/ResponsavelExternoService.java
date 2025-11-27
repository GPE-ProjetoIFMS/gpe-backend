package com.br.gpe.service;

import org.springframework.stereotype.Service;
import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import com.br.gpe.infraestructure.repository.ResponsavelExternoRepository;

@Service

public class ResponsavelExternoService {

    private final ResponsavelExternoRepository repository;

    public ResponsavelExternoService(ResponsavelExternoRepository repository) {
        this.repository = repository;
    }

    public void salvarResponsavelExterno(ResponsavelExterno responsavelExterno) {
        repository.saveAndFlush(responsavelExterno);
    }

    public ResponsavelExterno buscarResponsavelExternoPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("Cpf não encontrado."));
    }

    public void deletarResponsavelExternoPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }

    public void atualizarResponsavelExternoPorId(Long id, ResponsavelExterno responsavelExterno) {
        ResponsavelExterno ResponsavelExternoEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Responsável Externo não encontrado")));
        ResponsavelExterno responsavelExternoAtualizado = ResponsavelExterno.builder()
                .cpf(responsavelExterno.getCpf() != null ? responsavelExterno.getCpf() : ResponsavelExternoEntity.getCpf())
                .nome(responsavelExterno.getNome() != null ? responsavelExterno.getNome() : ResponsavelExternoEntity.getNome())
                .id(ResponsavelExternoEntity.getId())
                .build();
        repository.saveAndFlush(responsavelExternoAtualizado);

    }

}
