package com.board.game.controller;

import com.board.game.service.LudopediaAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth")
public class OAuthController {

    @Autowired
    private LudopediaAuthService ludopediaAuthService;

    @GetMapping("/callback")
    public ResponseEntity<String> handleCallback(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String error_description) {

        if (code != null) {
            // Troca o código pelo access_token usando o serviço
            String accessToken = ludopediaAuthService.exchangeCodeForAccessToken(code);
            return ResponseEntity.ok("Access Token recebido: " + accessToken);
        } else {
            // Tratar erros ou rejeições do usuário
            return ResponseEntity.badRequest().body("Erro: " + error + " - " + error_description);
        }
    }
}
