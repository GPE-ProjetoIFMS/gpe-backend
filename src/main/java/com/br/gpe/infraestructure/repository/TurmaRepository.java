package com.br.gpe.infraestructure.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;   
import com.br.gpe.infraestructure.entitys.Turma;

import jakarta.transaction.Transactional;


public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
