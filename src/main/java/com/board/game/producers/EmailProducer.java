package com.board.game.producers;

import com.board.game.controller.requestDto.EmailRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendEmailToQueue(EmailRequestDto emailRequestDto) {
        try {
            String json = objectMapper.writeValueAsString(emailRequestDto);
            rabbitTemplate.convertAndSend("emailQueue", json);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter EmailRequestDto para Json");
        }
    }
}
