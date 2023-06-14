package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Cliente;
import com.gympower.web.services.impl.ClienteServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/gympower/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
 
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;
}
