package org.binaryminds.gestionproyectos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column
    private String nombre;
    private String email;
    private String contrasena;
    private String rol;
}
