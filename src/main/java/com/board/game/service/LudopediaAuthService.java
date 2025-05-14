package com.board.game.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LudopediaAuthService {

    private final String appId = "5f748c38dafc9077";
    private final String appKey = "a96fc18a89a253b40fa15fbc095e4569";  // Substitua pelo seu app_key
    private final String tokenUrl = "https://ludopedia.com.br/tokenrequest";

    public String exchangeCodeForAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();

        // Configura os cabeçalhos
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(appId, appKey); // Adiciona autenticação Basic com app_id e app_key

        // Configura os parâmetros do corpo da requisição
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", code);

        // Cria a requisição HTTP
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // Faz o POST para a URL de troca de token
        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Retorna o corpo da resposta, que contém o access_token em JSON
            return response.getBody();
        } else {
            throw new RuntimeException("Falha ao trocar o código por um access_token: " + response.getStatusCode());
        }
    }
}
