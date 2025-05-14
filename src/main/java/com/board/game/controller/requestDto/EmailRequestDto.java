package com.board.game.controller.requestDto;

import com.board.game.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailRequestDto {

    private String to;
    private String subject;
    private String body;

    public EmailRequestDto(Email email) {
        this.to = email.to();
        this.subject = email.subject();
        this.body = email.body();
    }
}
