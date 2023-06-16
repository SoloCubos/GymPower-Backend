package com.gympower.web.entities;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Audited
@Table(name = "rol")
public class Rol extends BaseEntity{
    
    @Column(name = "nombre", length = 15)
    private String nombre;
}
