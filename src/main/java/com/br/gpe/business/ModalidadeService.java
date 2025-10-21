package com.br.gpe.business;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.gpe.dto.ModalidadeRequestDTO;
import com.br.gpe.dto.ModalidadeResponseDTO;
import com.br.gpe.infraestructure.entitys.Modalidade;
import com.br.gpe.infraestructure.repository.ModalidadeRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;


@Service

public class ModalidadeService {

    private final ModalidadeRepository repository;

    public ModalidadeService(ModalidadeRepository repository) {
        this.repository = repository;
    }
    @Transactional // Garante que a operação com o banco seja atômica
    public ModalidadeResponseDTO criarModalidade(ModalidadeRequestDTO dados) {
        
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
        return new ModalidadeResponseDTO(modalidadeSalva);
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

