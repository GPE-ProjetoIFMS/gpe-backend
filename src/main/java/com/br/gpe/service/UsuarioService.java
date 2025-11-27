package com.br.gpe.service; // ou package com.br.gpe.business;

import com.br.gpe.infraestructure.entitys.Usuario;
import com.br.gpe.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
    
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}