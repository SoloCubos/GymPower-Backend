package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Cliente;
import com.gympower.web.repositories.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClienteRepository clienteRepository;
    
@Override
	public UserDetails loadUserByUsername(String  correo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepository.findByCorreo(correo);
		if(cliente == null) {
			throw new UsernameNotFoundException("Codigo no encontrado");
		}
		return new UserDetailsImpl(cliente);
		
	}

}
