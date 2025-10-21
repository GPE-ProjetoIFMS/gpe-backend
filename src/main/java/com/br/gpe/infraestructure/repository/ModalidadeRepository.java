package com.br.gpe.infraestructure.repository;


import com.br.gpe.infraestructure.entitys.Modalidade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModalidadeRepository extends JpaRepository<Modalidade,Long> {

  Optional<Modalidade> findById(Long id);
  Optional<Modalidade> findByNome(String nome);
  Optional<Modalidade> findByCodigo(String codigo);

  @Transactional
  void deleteById(Long id);
}
