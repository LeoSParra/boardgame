package com.board.game.service;

import com.board.game.controller.requestDto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")  // obtem o remetente do arquivo de configuracao
    private String senderEmail;

    public void sendEmail(EmailRequestDto emailRequestDto) {
        var message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(emailRequestDto.getTo());
        message.setSubject(emailRequestDto.getSubject());
        message.setText(emailRequestDto.getBody());
        mailSender.send(message);
    }
}
