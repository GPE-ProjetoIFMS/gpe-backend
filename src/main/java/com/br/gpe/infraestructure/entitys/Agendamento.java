package com.br.gpe.infraestructure.entitys;

import java.time.LocalDate;

public class Agendamento {
    private Long id;
    private Turma turma;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private ResponsavelExterno responsavelExterno;
    private EspacoFisico espacoFisico;
}
