package com.br.gpe.controller;

import com.br.gpe.infraestructure.entitys.Usuario;
import com.br.gpe.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UsuarioService usuarioService;

    @GetMapping("/user-info")
    public String getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        // 1. Verifica se o usuário está logado
        if (principal == null) {
            return "Você não está logado! Acesse /login primeiro.";
        }

        // 2. Pega os dados vindos do Google
        String email = principal.getAttribute("email");
        String nome = principal.getAttribute("name");
        
        // 3. Tenta buscar no banco de dados local
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario == null) {
            // 4. Se não existir, cria e salva (A Mágica acontece aqui!)
            usuario = new Usuario();
            usuario.setLogin(email); // Usando o email como ID/Login
            usuario.setNome(nome);
            usuario.setEmail(email);
            // usuario.setSenha(""); // Senha vazia pois é login social
            
            usuarioService.salvar(usuario); // <--- SALVANDO NO BANCO
            
            return "<h1>Sucesso!</h1>" +
                   "<p>Novo usuário <b>CRIADO</b> no banco de dados.</p>" +
                   "<p>Nome: " + nome + "</p>" +
                   "<p>Email: " + email + "</p>";
        }

        // 5. Se já existir, apenas mostra
        return "<h1>Bem-vindo de volta!</h1>" +
               "<p>Usuário <b>ENCONTRADO</b> no banco de dados.</p>" +
               "<p>Nome: " + usuario.getNome() + "</p>" +
               "<p>Email: " + usuario.getEmail() + "</p>";
    }
}