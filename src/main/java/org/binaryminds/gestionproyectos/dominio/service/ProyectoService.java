package org.binaryminds.gestionproyectos.dominio.service;

import org.binaryminds.gestionproyectos.persistence.crud.ProyectoCrud;
import org.binaryminds.gestionproyectos.persistence.entity.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    ProyectoCrud crud;

    @Override
    public List<Proyecto> listarProyectos() {
        List<Proyecto> proyectos = crud.findAll();
        return proyectos;
    }

    @Override
    public void guardarProyecto(Proyecto proyecto) {
        crud.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) {
        crud.delete(proyecto);
    }

    @Override
    public Proyecto buscarProyectoPorId(Integer id) {
        Proyecto proyecto = crud.findById(id).orElse(null);
        return proyecto;
    }
}
