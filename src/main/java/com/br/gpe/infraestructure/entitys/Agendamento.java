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

    @ManyToOne // Indica o relacionamento
    @JoinColumn(name = "turma_id", nullable = false) // Define a coluna de chave estrangeira
    private Turma turma;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @ManyToOne // Indica o relacionamento
    @JoinColumn(name = "responsavel_externo_id", nullable = false) // Define a coluna de chave estrangeira
    private ResponsavelExterno responsavelExterno;

    @ManyToOne // Indica o relacionamento
    @JoinColumn(name = "especo_fisico_id", nullable = false) // Define a coluna de chave estrangeira
    private EspacoFisico espacoFisico;

    @Column(name = "dataFinal", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "horarioFinal", nullable = false)
    private ZonedDateTime horarioFinal;

}
