package org.binaryminds.gestionproyectos.web.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class IndexController {

    private String mensaje= "Bienvenido a tu Aplicacion de Gestion de Proyectos";
    public String irLogin(){
        return "menu_principal.xhtml?faces-redirect=true";
    }

    public String irRegistrarUsuarios(){
        return "registrarse.xhtml?faces-redirect=true";
    }

    public String irAcercaDe(){
        return "acerca_de.xhtml?faces-redirect=true";
    }

}
