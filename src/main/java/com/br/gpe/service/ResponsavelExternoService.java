package com.br.gpe.service;

import com.br.gpe.dto.ResponsavelExternoRequest;
import com.br.gpe.dto.ResponsavelExternoResponse;
import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import com.br.gpe.infraestructure.repository.ResponsavelExternoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponsavelExternoService {

    private final ResponsavelExternoRepository repository;

    @Transactional
    public ResponsavelExternoResponse salvar(ResponsavelExternoRequest dados) {
        ResponsavelExterno responsavel = new ResponsavelExterno();
        responsavel.setNome(dados.nome());
        responsavel.setCpf(dados.cpf());
        responsavel.setDataNascimento(dados.dataNascimento());
        responsavel.setTelefone(dados.telefone());

        repository.save(responsavel);
        return new ResponsavelExternoResponse(responsavel);
    }

    public ResponsavelExternoResponse buscarPorId(Long id) {
        ResponsavelExterno responsavel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável Externo não encontrado."));
        return new ResponsavelExternoResponse(responsavel);
    }

    public List<ResponsavelExternoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(ResponsavelExternoResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponsavelExternoResponse atualizar(Long id, ResponsavelExternoRequest dados) {
        ResponsavelExterno responsavel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável Externo não encontrado"));

        responsavel.setNome(dados.nome());
        responsavel.setCpf(dados.cpf());
        responsavel.setDataNascimento(dados.dataNascimento());
        responsavel.setTelefone(dados.telefone());

        repository.save(responsavel);
        return new ResponsavelExternoResponse(responsavel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}