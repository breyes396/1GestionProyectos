package org.binaryminds.gestionproyectos.dominio.service;

import java.util.List;
import org.binaryminds.gestionproyectos.persistence.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    void guardarUsuario(Usuario usuario);
    boolean verificarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}
