package com.javierborreguero.tfg_hazt_ver_javier_borreguero.controller;

import com.javierborreguero.tfg_hazt_ver_javier_borreguero.entity.Personal;
import com.javierborreguero.tfg_hazt_ver_javier_borreguero.service.EmailService;
import com.javierborreguero.tfg_hazt_ver_javier_borreguero.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Clase que se encarga de atender peticiones y derivarnos a la vista correspondiente
 */
@Controller
public class MainController {
    @Autowired
    private PersonalService personalService;
    private EmailService emailService;

    public MainController(PersonalService personalService, EmailService emailService) {
        this.personalService = personalService;
        this.emailService = emailService;
    }

    @GetMapping("/")
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

    @GetMapping("/Cv")
    public String MyCurriculum() {
        return "My_Curriculum";
    }

    // Send email
    @PostMapping("/sendEmail")
    public String sendEmail(HttpServletRequest request) {
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        emailService.sendMessage(
                "javierborreguerodelpozo@gmail.com",
                fullName + " " + "ha enviado un mensaje",
                "E-mail: " + email + "\n" + "Asunto: " + subject + "\n" + message + ""
        );
        return "Contact_Me";
    }
}
