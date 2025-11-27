package com.br.gpe.service; // Ou package com.br.gpe.business;

import com.br.gpe.infraestructure.entitys.Perfil;
import com.br.gpe.infraestructure.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;

    public Perfil salvar(Perfil perfil) {
        return repository.save(perfil);
    }

    public List<Perfil> listarTodos() {
        return repository.findAll();
    }
}