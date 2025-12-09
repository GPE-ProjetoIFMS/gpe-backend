package com.br.gpe.infraestructure.entitys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author 1513003
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public class MappedBase {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mappedSequence")
    private Long id;

    @ToString.Include
    private String nome;

}
