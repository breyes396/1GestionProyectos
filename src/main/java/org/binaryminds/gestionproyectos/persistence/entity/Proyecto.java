package org.binaryminds.gestionproyectos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity(name = "Proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proyecto;
    @Column
    private String nombre;
    private LocalDate fecha_inicio;
}
