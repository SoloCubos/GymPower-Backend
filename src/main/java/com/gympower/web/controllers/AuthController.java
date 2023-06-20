package com.gympower.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.DTO.CrearUsuarioDTO;
import com.gympower.web.DTO.LoginRequest;
import com.gympower.web.DTO.LoginResponse;
import com.gympower.web.entities.Rol;
import com.gympower.web.entities.RolEnum;
import com.gympower.web.entities.Usuario;
import com.gympower.web.services.impl.UsuarioServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(path = "/login")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;


    @GetMapping("/index")
    public String index(){
        return "Pene Enorme";
    }

    @GetMapping("/index2")
    public String index2(){
        return "Pene Enano";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody CrearUsuarioDTO crearUsuarioDTO){
        try {
            Set<Rol> roles = crearUsuarioDTO.getRoles().stream()
                         .map(role -> Rol.builder()
                                         .nombre(RolEnum.valueOf(role))
                                         .build())
                         .collect(Collectors.toSet());

            System.out.println("Algun error creando el rol?");

            Usuario user =  Usuario.builder()
                               .nombre(crearUsuarioDTO.getNombre())
                               .apellido(crearUsuarioDTO.getApellido())
                               .cedula(crearUsuarioDTO.getCedula())
                               .genero(crearUsuarioDTO.getGenero())
                               .edad(crearUsuarioDTO.getEdad())
                               .username(crearUsuarioDTO.getUsername())
                               .correo(crearUsuarioDTO.getCorreo())
                               .password(passwordEncoder.encode(crearUsuarioDTO.getPassword()))
                               .roles(roles)
                               .build();
            
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error 69, Por favor intente mas tarde.\"}");
        }
    }
    /*
    @GetMapping("/session")
    public ResponseEntity<?> getDetailsSession(){

        String sessionId = "";
        User userObjetct = null;

        List<Object> sessions = sessionRegistry.getAllPrincipals();

        for (Object session : sessions) {
            if(session instanceof User){
                userObjetct = (User) session;
            }

            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);

            for (SessionInformation sessionInformation : sessionInformations) {
                sessionId = sessionInformation.getSessionId();
            }
        }

        Map<String, Object> response = new HashMap<>();
            response.put("response", "Ola Mundo");
            response.put("sessionId", sessionId);
            response.put("sessionUser", userObjetct);
            
        return ResponseEntity.ok(response);
    }*/
}
