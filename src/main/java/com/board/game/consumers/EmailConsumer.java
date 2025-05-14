package com.board.game.consumers;

import com.board.game.controller.requestDto.EmailRequestDto;
import com.board.game.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmailConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "emailQueue")
    public void receiveEmail(String message) {
        try {
            EmailRequestDto emailRequestDto = objectMapper.readValue(message, EmailRequestDto.class);
            emailService.sendEmail(emailRequestDto);
        } catch (Exception e) {
            System.err.println("Erro ao converter mensagem para EmailRequestDto: " + e.getMessage());
        }
    }
}
