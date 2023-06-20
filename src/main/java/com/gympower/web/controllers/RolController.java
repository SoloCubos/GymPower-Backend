package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    /* Testeo de Roles
    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public String accesAdmin(){
        return "Acceso como ADMINISTRADOR";
    }

    @GetMapping("/accessInstructor")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public String accesInstructor(){
        return "Acceso como INSTRUCTOR";
    }

    @GetMapping("/accessCliente")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'CLIENTE')")
    public String accesCliente(){
        return "Acceso como CLIENTE";
    }*/
    
}
