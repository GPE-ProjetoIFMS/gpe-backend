package com.br.gpe.infraestructure.repository;

import com.br.gpe.infraestructure.entitys.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}