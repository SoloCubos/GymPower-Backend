package com.gympower.web.entities;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "instructor")
public class Instructor extends BaseEntity{
    
    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "apellido", length = 20)
    private String apellido;

    @Column(name = "genero", length = 10)
    private String genero;

    @Column(name = "cedula", length = 10)
    private String cedula;

    @Column(name = "edad")
    private Byte edad;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String contraseña;


}
