package com.board.game.rabbitMQ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue emailQqueue() {
        return new Queue("emailQueue", true);   // nome da fila e persistencia ativada
    }
}
