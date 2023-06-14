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
@AllArgsConstructor
@NoArgsConstructor
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Integer> baseRepository) {
        super(baseRepository);
    }

}
