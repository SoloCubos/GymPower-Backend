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

    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = false)
    @JoinTable(name = "cliente_rutina",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "rutina_id"))
    private List<Rutina> rutinas = new ArrayList<Rutina>();

    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles = new ArrayList<Rol>();

}
