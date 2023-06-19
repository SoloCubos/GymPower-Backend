package com.gympower.web.services.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Usuario;
import com.gympower.web.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario= usuarioRepository.findByCorreo(correo);
        if (usuario == null) {
            throw new UsernameNotFoundException("Cliente no encontrado con email: " + correo);
        }
        
        return new UserDetailsImpl(usuario);
    }
    
}
