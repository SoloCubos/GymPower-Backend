package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Ejercicio;
import com.gympower.web.services.impl.EjercicioServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/gympower/ejercicios")
public class EjercicioController extends BaseControllerImpl<Ejercicio, EjercicioServiceImpl>{

    @Autowired
    private EjercicioServiceImpl ejercicioServiceImpl;
    
}
