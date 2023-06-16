package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Cliente;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.ClienteRepository;
import com.gympower.web.services.ClienteService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Boolean existsByCorreo(String correo) throws Exception {
        try {
            System.out.println(clienteRepository.existsByCorreo(correo));
            return clienteRepository.existsByCorreo(correo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String encontrarPassPorCorreo(String correo) throws Exception {
        try {
            
            String contraseña = clienteRepository.encontrarPassPorCorreo(correo);
            System.out.println(contraseña);
            return contraseña;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    

    

}
