package com.upiiz.hospital.services;

public interface EmailService {
    void enviarCorreo(String destinatario, String asunto, String cuerpo);
}