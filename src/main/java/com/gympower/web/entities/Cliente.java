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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name="cliente")
public class Cliente extends BaseEntity{

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "apellido", length = 20)
    private String apellido;

    @Column(name = "genero", length = 20)
    private String genero;

    @Column(name = "cedula", length = 10)
    private String cedula;

    @Column(name = "edad")
    private Byte edad;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "password", length = 100)
    private String contraseña;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_instructor_id")
    private Instructor instructor;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_rutina_id")
    private Rutina rutina;
}
