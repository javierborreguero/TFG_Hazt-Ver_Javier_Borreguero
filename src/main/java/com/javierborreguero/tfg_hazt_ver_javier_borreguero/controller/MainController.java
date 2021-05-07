package com.javierborreguero.tfg_hazt_ver_javier_borreguero.controller;

import com.javierborreguero.tfg_hazt_ver_javier_borreguero.entity.Personal;
import com.javierborreguero.tfg_hazt_ver_javier_borreguero.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Clase que se encarga de atender peticiones y derivarnos a la vista correspondiente
 */
@Controller
public class MainController {
    @Autowired
    private PersonalService personalService;

    @RequestMapping("/")

    public String aboutMe(Model model) {
        List<Personal> personalInfo = personalService.listAll();
        model.addAttribute("personalInfo", personalInfo);
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
