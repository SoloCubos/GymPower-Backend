package com.gympower.web.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gympower.web.DTO.LoginRequest;
import com.gympower.web.services.impl.UserDetailsImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, 
                                                HttpServletResponse response) throws AuthenticationException {
        
        LoginRequest authCredentials = new LoginRequest();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), LoginRequest.class);
        } catch (IOException e) {
            // TODO: handle exception
        }                                        
        
        UsernamePasswordAuthenticationToken userPAT = new UsernamePasswordAuthenticationToken(authCredentials.getCorreo(), 
                                                                                            authCredentials.getPassword(),
                                                                                            Collections.emptyList());
          return getAuthenticationManager().authenticate(userPAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, 
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
        String token = JwtTokenUtil.createToken(userDetailsImpl.getNombre(), userDetailsImpl.getUsername());

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult);
    }

    
    /* 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        
        String email = null;
        String jwtToken = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            try {
				email = this.jwtTokenUtil.extractEmail(jwtToken);
			} catch (ExpiredJwtException expiredJwtException) {
				System.out.println("EL token ha expirado");
			} catch (Exception e) {
				e.printStackTrace();
			}
        }else System.out.println("Token Invalido, la cadena no empieza con ´Bearer ´");
        
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(email);
            
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken
                    (userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else System.out.println("Token Invalido");
        
        chain.doFilter(request, response);
    }*/
}

