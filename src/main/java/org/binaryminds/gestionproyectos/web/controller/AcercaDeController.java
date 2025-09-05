package org.binaryminds.gestionproyectos.web.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class AcercaDeController {

    public String regresarMenuPrincipal(){
        return "index.xhtml?faces-redirect=true";
    }
}
