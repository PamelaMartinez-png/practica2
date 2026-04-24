package com.upiiz.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    // ESTO ES LO CORRECTO: Inyectar la herramienta de Spring, no el servicio mismo
    @Autowired
    private JavaMailSender mailSender;

//    @Override
//    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
//        SimpleMailMessage mensaje = new SimpleMailMessage();
//        mensaje.setTo(destinatario);
//        mensaje.setSubject(asunto);
//        mensaje.setText(cuerpo);
//
//        // Usamos el objeto mailSender que inyectamos arriba
//        mailSender.send(mensaje);
//    }

    @Override
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        System.out.println("Intentando enviar correo a: " + destinatario);
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mailSender.send(mensaje);
        System.out.println("Correo enviado");
    }
}