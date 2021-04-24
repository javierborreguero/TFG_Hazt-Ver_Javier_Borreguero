package com.javierborreguero.tfg_hazt_ver_javier_borreguero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Clase que se encarga de atender peticiones y derivarnos a la vista correspondiente
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String aboutMe() {
        return "Main_Screen";
    }

    @GetMapping("/Projects")
    public String MyProjects() {
        return "My_Projects";
    }

    @GetMapping("/Contact")
    public String ContactMe() {
        return "Contact_Me";
    }
}
