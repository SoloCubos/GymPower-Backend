package com.gympower.web.entities;


import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ejercicio")
@Audited
public class Ejercicio extends BaseEntity{
	
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "repeticiones")
    private Short repeticiones;

    @Column(name = "descipcion", length = 2500)
    private String decripcion;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_maquina_id")
    private Maquina maquina;



}