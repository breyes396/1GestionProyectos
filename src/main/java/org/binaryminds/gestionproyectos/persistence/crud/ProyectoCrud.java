package org.binaryminds.gestionproyectos.persistence.crud;

import org.binaryminds.gestionproyectos.persistence.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoCrud extends JpaRepository<Proyecto, Integer> {
}
