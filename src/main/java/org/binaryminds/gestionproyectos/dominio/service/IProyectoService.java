package org.binaryminds.gestionproyectos.dominio.service;

import org.binaryminds.gestionproyectos.persistence.entity.Proyecto;

import java.util.List;

public interface IProyectoService {
    List<Proyecto> listarProyectos();
    void guardarProyecto(Proyecto proyecto);
    Proyecto buscarProyectoPorId(Integer id);
    void eliminarProyecto(Proyecto proyecto);
}
