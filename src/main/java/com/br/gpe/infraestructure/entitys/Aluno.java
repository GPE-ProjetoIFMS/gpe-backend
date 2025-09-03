package com.br.gpe.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "aluno")
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "rg", unique = true, nullable = false)
    private String rg;
    
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column (name = "telefone", nullable = false)
    private String telefone;
    
    @Column(name = "nomeResponsavel", nullable = false)
    private String nomeResponsavel;
    
    @Column (name = "telefoneResponsavel", nullable = false)
    private String telefoneResponsavel;
    

}
