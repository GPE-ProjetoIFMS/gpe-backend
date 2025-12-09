package com.br.gpe.infraestructure.repository;

import com.br.gpe.infraestructure.entitys.Agendamento;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

 Optional<Agendamento> findById(Long id);
 
    @Transactional
    void deleteById(Long id);

}
