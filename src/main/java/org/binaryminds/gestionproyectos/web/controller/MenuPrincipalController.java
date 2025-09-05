package org.binaryminds.gestionproyectos.web.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class MenuPrincipalController {

    //implementar metodos de sprint 3
    public String irIndex(){
        return "index.xhtml?faces-redirect=true";
    }

}
