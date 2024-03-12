package com.example.Fixture.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Slf4j
public class CustomAthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("METODO DE AUTENTICACION : " + request.getMethod());
        System.out.println("ENCABEZADO DE AUTORIZACION :  : " + request.getHeader(AUTHORIZATION));
        System.out.println("URL :  : " + request.getRequestURI());

        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            System.out.println("PRIMER IF OPTIOS");
            // Si es una solicitud OPTIONS, devuelve un estado autorizado (HTTP 200) sin procesar la autenticación.
            response.setStatus(HttpStatus.OK.value());
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type,X-Requested-With");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        } else {
            if (request.getServletPath().equals("/api/users/login")
                    || request.getServletPath().equals("/api/users/token/refresh")) {
                response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                filterChain.doFilter(request, response);
            } else {
                String authorizationHeader = request.getHeader(AUTHORIZATION);
                System.out.println(authorizationHeader);
                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                    try {
                        String token = authorizationHeader.substring("Bearer ".length());
                        System.out.println("TOKEN : " + token);
                        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                        JWTVerifier verifier = JWT.require(algorithm).build();
                        //ERROR AQUI
                        DecodedJWT decodedJWT = verifier.verify(token);
                        System.out.println("Decodificación JWT: " + decodedJWT.getPayload());
                        String username = decodedJWT.getSubject();
                        System.out.println("USERNAME = " + username);
                        String[] roles = decodedJWT.getClaim("autoridades").asArray(String.class);
                        System.out.println("ROLES  = " + Arrays.toString(roles));
                        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                        Arrays.stream(roles).forEach(role -> {
                            authorities.add(new SimpleGrantedAuthority(role));
                        });
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                username, null, authorities);
                        System.out.println("AUTH TOKEN = " + authenticationToken);
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        System.out.println("REQUEST = " + request.getRequestURL() + " RESPONSE = " + response.getStatus());
                        response.setStatus(HttpStatus.OK.value());
                        filterChain.doFilter(request, response);
                    } catch (Exception exception) {
                        log.error("Error en el logging en: {}", exception.getMessage());
                        response.setHeader("error", exception.getMessage());
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        // response.sendError(HttpStatus.FORBIDDEN.value());
                        Map<String, String> error = new HashMap<>();
                        error.put("error_message", exception.getMessage());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        new ObjectMapper().writeValue(response.getOutputStream(), error);
                        // TODO: handle exception
                    }
                } else {
                    System.out.println("CHATCHATCHAT");
                    System.out.println("REQUEST = " + request.getRequestURL() + request.getMethod() + " RESPONSE = " + response.getStatus());
                    filterChain.doFilter(request, response);
                }
            }
        }
    }
}
