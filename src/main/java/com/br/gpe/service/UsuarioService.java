package com.br.gpe.service;

import com.br.gpe.infraestructure.entitys.Usuario;
import com.br.gpe.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService { // <--- MUDANÇA 1

    private final UsuarioRepository repository;

    // --- MUDANÇA 2: Método obrigatório do Spring Security ---
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username) // Como seu ID é o login
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }
    // -------------------------------------------------------

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