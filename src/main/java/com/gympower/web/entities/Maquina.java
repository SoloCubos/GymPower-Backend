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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "herramienta")
@Audited
public class Maquina extends BaseEntity{
	
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 2000)
    private String descripcion;

}
