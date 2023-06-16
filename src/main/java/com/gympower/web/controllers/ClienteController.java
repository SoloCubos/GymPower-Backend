package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.DTO.JwtRequest;
import com.gympower.web.entities.Cliente;
import com.gympower.web.services.impl.ClienteServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/gympower/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
 
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    /**
     * Login sin Seguridad xD
    @PostMapping("/login")
    public ResponseEntity<?> validarCredenciales(@RequestBody JwtRequest loginRequest){
        try {

            if(!(servicio.existsByCorreo(loginRequest.getCorreo()) && servicio.encontrarPassPorCorreo(loginRequest.getCorreo()).equals(loginRequest.getPassword()))){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\":\"Error 69, Credenciales Incorrectas.\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("{\"succsess\":\"Ha iniciado sexión\"}");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error 69, Por favor intente mas tarde.\"}");
        }
    }
    */

}
