/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.gpe.infraestructure.entitys;

import java.time.LocalDate;
import java.util.List;

import com.br.gpe.enumeration.NivelHabilidade;
import jakarta.persistence.Column;
/**
 *
 * @author 07014437151
 */
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Turma")
@Entity
public class Turma {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nome", unique = true, nullable = false)
private String nome;

 @Column(name = "modalidade", nullable = false)
private Modalidade modalidade;

@Enumerated(EnumType.STRING)
@Column(name = "nivel", nullable = false)
private NivelHabilidade nivel;

@OneToMany(mappedBy = "turma")
private List<Matricula> matriculas;

 @Column(name = "professor", nullable = false)
private Professor professor;

 @Column(name = "qntdAluno", nullable = false)
private Integer qntdAlunos;

 @Column(name = "dataInicio", nullable = false)
 private LocalDate dataInicio;

 @Column(name = "dataFinal", nullable = false)
 private LocalDate dataFinal;

}
