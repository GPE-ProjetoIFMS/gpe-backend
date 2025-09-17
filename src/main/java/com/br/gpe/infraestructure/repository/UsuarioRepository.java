package com.br.gpe.infraestructure.repository;


import com.br.gpe.infraestructure.entitys.Usuario;
import jakarta.transaction.Transactional;   
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
