package com.br.gpe;

import com.br.gpe.enumeration.Status;
import com.br.gpe.infraestructure.entitys.Usuario;
import com.br.gpe.infraestructure.repository.UsuarioRepository;
import com.br.gpe.security.enumeration.SocialAuthProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpeApplication.class, args);
    }

    // Este método roda automaticamente ao iniciar o sistema
    @Bean
    CommandLineRunner init(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verifica se o usuário 'admin' já existe (para não duplicar se mudar o banco para arquivo)
            if (repository.findById("admin").isEmpty()) {
                
                Usuario admin = new Usuario();
                admin.setLogin("admin");
                admin.setNome("Administrador do Sistema");
                admin.setEmail("admin@gpe.com");
                // AQUI ESTÁ O SEGREDO: Criptografar a senha antes de salvar
                admin.setSenha(passwordEncoder.encode("123456")); 
                admin.setBloqueado(false);
                admin.setStatus(Status.ATIVO);
                admin.setAuthProvider(SocialAuthProvider.LOCAL);
                
                repository.save(admin);
                
                System.out.println("----------------------------------------------------------");
                System.out.println(" USUÁRIO DE TESTE CRIADO COM SUCESSO");
                System.out.println(" Login: admin");
                System.out.println(" Senha: 123456");
                System.out.println("----------------------------------------------------------");
            }
        };
    }
}