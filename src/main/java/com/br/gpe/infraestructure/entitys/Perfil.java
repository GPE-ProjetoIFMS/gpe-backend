package com.br.gpe.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // Mudei de @SuperBuilder para @Builder simples
@Entity
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: ROLE_ADMIN (Este é o campo que o getNome() buscava)

    private String descricao;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nome;
    }
}