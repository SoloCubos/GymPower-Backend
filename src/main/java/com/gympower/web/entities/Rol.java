package com.gympower.web.entities;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Audited
@Table(name = "rol")
public class Rol extends BaseEntity{

    @Column(name = "nombre_rol", length = 20)
    String nombre;

}