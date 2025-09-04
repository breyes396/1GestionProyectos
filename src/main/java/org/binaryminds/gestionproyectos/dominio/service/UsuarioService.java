package org.binaryminds.gestionproyectos.dominio.service;

import org.binaryminds.gestionproyectos.persistence.crud.UsuarioCrud;
import org.binaryminds.gestionproyectos.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioCrud crud;

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario>usuarios = crud.findAll();
        return usuarios;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        crud.save(usuario);
    }

    @Override
    public boolean verificarUsuario(Usuario usuario) {
        List<Usuario> usuarios = crud.findAll();
            if (usuarios.contains(usuario)){
                return true;
            }
        return false;
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        crud.delete(usuario);
    }
}
