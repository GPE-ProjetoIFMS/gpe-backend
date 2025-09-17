/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.gpe.infraestructure.entitys;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "responsavelExterno")


public class ResponsavelExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;
       
    @Column (name = "telefone", nullable = false)
    private String telefone;
    


}

