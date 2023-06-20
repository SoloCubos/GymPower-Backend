package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.entities.Rol;
import com.gympower.web.services.impl.RolServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/roles")
public class RolController extends BaseControllerImpl<Rol, RolServiceImpl>{

    @Autowired
    private RolServiceImpl rolServiceImpl;
    
}
