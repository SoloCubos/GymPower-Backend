package com.gympower.web.entities;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Audited
@Table(name = "rol")
public class Rol extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RolEnum nombre;

}