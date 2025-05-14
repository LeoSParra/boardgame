package com.board.game.security;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@Order(1)   // o filtro será executado antes dos controllers
public class StaticTokenFilter extends OncePerRequestFilter {

    private static final String STATIC_TOKEN = "MeuToken";

    @Override
    protected void doFilterInternal(HttpServletRequest request , HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        //verificar se header authorization está presente e tem "baerer {token}"
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token ausente");
            return;
        }
        // Extrai o token do header (remove o bearer e pega o valor)
        String token = authorizationHeader.substring(7).trim();

        if(!STATIC_TOKEN.equals(token)) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token inválido");
            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken("user", null, List.of(new SimpleGrantedAuthority("ROLE_USER")));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // se o token for válido, continua a execução
        filterChain.doFilter(request, response);
    }

}
