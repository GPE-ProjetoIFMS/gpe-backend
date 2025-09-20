package com.br.gpe.infraestructure.entitys;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_turma", unique = true, nullable = false)
    private Turma turma;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "responsavel_externo")
    private ResponsavelExterno responsavelExterno;

    @Column(name = "id_espaco_fisico", nullable = false)
    private EspacoFisico espacoFisico;

    @Column(name = "dataFinal", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "horarioFinal", nullable = false)
    private ZonedDateTime horarioFinal;

}
