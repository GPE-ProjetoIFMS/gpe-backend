package com.br.gpe.infraestructure.repository;

import com.br.gpe.infraestructure.entitys.EspacoFisico;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EspacoFisicoRepository extends JpaRepository<EspacoFisico, Long> {

    Optional<EspacoFisico> findById(Long id);

    @Transactional
    void deleteById(Long id); // <--- CORRIGIDO: de deleteByCpf para deleteById
}
