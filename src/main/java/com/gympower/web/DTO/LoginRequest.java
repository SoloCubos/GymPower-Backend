package com.gympower.web.DTO;


import lombok.Data;

@Data
public class LoginRequest {
    
    private String correo;

    private String password;

}
