/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.gpe.infraestructure.entitys;

import lombok.*;


import java.time.LocalDate;

import jakarta.persistence.*;


/**
 *
 * @author 07014437151
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", unique = true, nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @Column(name = "data", nullable = false)
    private LocalDate data;
}
