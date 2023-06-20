package com.gympower.web.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Usuario;
import com.gympower.web.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImlp implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username)
                                                   .orElseThrow(() -> new UsernameNotFoundException("El usuario " +  username + " no Existe."));
        
        Collection<? extends GrantedAuthority> authorities = usuario
                            .getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getNombre().name())))
                            .collect(Collectors.toSet());

        return new User(usuario.getUsername(), 
                        usuario.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        authorities);
    }
    
}
