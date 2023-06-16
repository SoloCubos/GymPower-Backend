package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Rutina;
import com.gympower.web.services.impl.RutinaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rutinas")
public class RutinaController extends BaseControllerImpl<Rutina, RutinaServiceImpl>{

    @Autowired
    private RutinaServiceImpl rutinaServiceImpl;
    
}
