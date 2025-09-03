/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.gpe.infraestructure.entitys;

import java.util.List;

import com.br.gpe.enumeration.NivelHabilidade;

import jakarta.persistence.Column;
/**
 *
 * @author 07014437151
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Turma")
@Entity
public class Turma {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "codigo", unique = true, nullable = false)
private String codigo;

 @Column(name = "modalidade", nullable = false)
private Modalidade modalidade;

 @Column(name = "nivel", nullable = false)
private NivelHabilidade nivel;


private List<Aluno> alunos;

 @Column(name = "professor", nullable = false)
private Professor professor;

 @Column(name = "qntdAluno", nullable = false)
private Integer qntdAlunos;



}
