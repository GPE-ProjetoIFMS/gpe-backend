package com.br.gpe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.gpe.dto.ModalidadeRequest;
import com.br.gpe.dto.ModalidadeResponse;
import com.br.gpe.infraestructure.entitys.Modalidade;
import com.br.gpe.infraestructure.repository.ModalidadeRepository;
import java.util.List;

import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;


@Service

public class ModalidadeService {

    private final ModalidadeRepository repository;

    public ModalidadeService(ModalidadeRepository repository) {
        this.repository = repository;
    }
    @Transactional // Garante que a operação com o banco seja atômica
    public ModalidadeResponse criarModalidade(ModalidadeRequest dados) {
        
        // 1. BOA PRÁTICA: Verificar se já existe uma modalidade com este código
        Optional<Modalidade> modalidadeExistente = repository.findByCodigo(dados.codigo());
        if (modalidadeExistente.isPresent()) {
            // Se existir, lançamos um erro. O Controller vai capturar isso.
            throw new EntityExistsException("Já existe uma modalidade com o código: " + dados.codigo());
        }

        // 2. Converter o DTO (dados de entrada) em uma Entidade (objeto do banco)
        Modalidade novaModalidade = new Modalidade();
        novaModalidade.setNome(dados.nome());
        novaModalidade.setCodigo(dados.codigo());
        
        // 3. Salvar a nova entidade no banco de dados
        Modalidade modalidadeSalva = repository.save(novaModalidade);

        // 4. Converter a Entidade salva (que agora tem ID) em um DTO de Resposta
        //    (Estamos usando aquele construtor prático que criamos no ResponseDTO)
        return new ModalidadeResponse(modalidadeSalva);
    }

    public void salvarModalidade(Modalidade modalidade) {
        repository.saveAndFlush(modalidade);
    }

  public ModalidadeResponse buscarModalidadePorId(Long id) {
    Modalidade modalidade = repository.findById(id).orElseThrow(
            () -> new RuntimeException("Id não encontrado."));
    return new ModalidadeResponse(modalidade); // Conversão adicionada
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

    public List<ModalidadeResponse> listarTodas() {
        return repository.findAll().stream()
                .map(ModalidadeResponse::new)
                .toList();
    }

}

