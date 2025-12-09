package com.br.gpe.infraestructure.entitys;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "turma_id", nullable = true) // MUDOU: Era false, agora é true (opcional)
    private Turma turma;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @ManyToOne 
    @JoinColumn(name = "responsavel_externo_id", nullable = true) // MUDOU: Era false, agora é true (opcional)
    private ResponsavelExterno responsavelExterno;

    @ManyToOne
    @JoinColumn(name = "especo_fisico_id", nullable = false)
    private EspacoFisico espacoFisico;

    @Column(name = "dataFinal", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "horarioFinal", nullable = false)
    private ZonedDateTime horarioFinal;

}