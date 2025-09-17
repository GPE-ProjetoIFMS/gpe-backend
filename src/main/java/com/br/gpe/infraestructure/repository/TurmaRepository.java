package com.br.gpe.infraestructure.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.transaction.Transactional;
import com.br.gpe.infraestructure.entitys.Turma;


public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findById(Long id);
    @Transactional
    void deleteById(Long id);
}
