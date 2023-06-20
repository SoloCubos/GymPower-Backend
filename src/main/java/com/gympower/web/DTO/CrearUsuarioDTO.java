package com.gympower.web.DTO;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearUsuarioDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String genero;

    @NotNull
    private Integer cedula;

    @NotNull
    private Byte edad;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String password;


    private Set<String> roles;

}
