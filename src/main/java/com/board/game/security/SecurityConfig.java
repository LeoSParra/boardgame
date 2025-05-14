package com.board.game.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration // indica que é uma classe de configuração
public class SecurityConfig {

    private final StaticTokenFilter staticTokenFilter;

    public SecurityConfig(StaticTokenFilter staticTokenFilter) {
        this.staticTokenFilter = staticTokenFilter;
    }

    @Bean // Adicione esta anotação para que o Spring gerencie este método
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable() // Desabilita proteção CSRF (não necessária para APIs REST sem estado)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura sessões como "stateless"
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/public/**").permitAll()
                        .anyRequest().hasRole("USER") // Exige que o usuário tenha a role USER para acessar qualquer outra url
                )
                .addFilterBefore(staticTokenFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro personalizado antes do filtro padrão de autenticação do Spring Security
                .build();
    }
}
