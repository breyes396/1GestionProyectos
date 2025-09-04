package org.binaryminds.gestionproyectos.persistence.crud;

import org.binaryminds.gestionproyectos.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioCrud extends JpaRepository<Usuario, Integer>  {
}
