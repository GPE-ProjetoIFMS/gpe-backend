package com.br.gpe.infraestructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.gpe.infraestructure.entitys.Professor;
import jakarta.transaction.Transactional;

public interface ProfessorRepository extends JpaRepository<Professor, Long>  {

    Optional<Professor> findByCpf(String cpf);

    
    Optional<Professor> findByNome(String nome);
    @Transactional
    void deleteByCpf(String cpf);
}
