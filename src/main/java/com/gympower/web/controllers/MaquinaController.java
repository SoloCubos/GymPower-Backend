package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Maquina;
import com.gympower.web.services.impl.MaquinaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/maquinas")
public class MaquinaController extends BaseControllerImpl<Maquina, MaquinaServiceImpl>{

    @Autowired
    private MaquinaServiceImpl maquinaServiceImpl;
    
}
