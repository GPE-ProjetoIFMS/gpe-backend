/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.gpe.infraestructure.entitys;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@Table(name = "modalidade")
@Entity


public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;


    @Column(name = "codigo", unique = true, nullable = false, length = 10)
    private String codigo;



}

