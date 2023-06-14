package com.gympower.web.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
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
@Table(name = "rutina")
@Audited
public class Rutina extends BaseEntity{	

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 2500)
    private String descripcion;

    @Column(name = "tiempo")
    private String tiempo;

    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = false)
    @JoinTable(name = "rutina_ejercicio",
            joinColumns = @JoinColumn(name = "rutina_id"),
            inverseJoinColumns = @JoinColumn(name = "ejercicio_id"))
    private List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();

}
