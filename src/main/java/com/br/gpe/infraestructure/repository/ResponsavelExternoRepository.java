package com.br.gpe.infraestructure.repository;


import com.br.gpe.infraestructure.entitys.ResponsavelExterno;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsavelExternoRepository extends JpaRepository<ResponsavelExterno,Long> {

  Optional<ResponsavelExterno> findByCpf(String cpf);

  @Transactional
  void deleteByCpf(String cpf);
}

