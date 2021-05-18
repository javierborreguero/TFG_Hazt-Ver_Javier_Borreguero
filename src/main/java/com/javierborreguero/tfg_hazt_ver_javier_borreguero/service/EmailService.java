package com.javierborreguero.tfg_hazt_ver_javier_borreguero.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(String to, String subject, String emailContent) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("javiborreguero96@gmail.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(emailContent);
//        javaMailSender.send(message);
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom("javiborreguero96@gmail.com", "Hate-Ver");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(emailContent);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}