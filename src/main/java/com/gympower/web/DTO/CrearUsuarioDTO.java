package com.gympower.web.DTO;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Integer cedula;

    @NotBlank
    private Byte edad;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String password;
    private Set<String> rol;

}
