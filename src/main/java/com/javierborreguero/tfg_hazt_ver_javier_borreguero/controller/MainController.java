package com.javierborreguero.tfg_hazt_ver_javier_borreguero.controller;

import com.javierborreguero.tfg_hazt_ver_javier_borreguero.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Clase que se encarga de atender peticiones y derivarnos a la vista correspondiente
 */
@Controller
public class MainController {
    @Autowired
    private EmailService emailService;

    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }

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
