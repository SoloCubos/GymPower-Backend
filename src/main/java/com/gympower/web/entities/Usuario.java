package com.gympower.web.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name="usuario")
public class Usuario extends BaseEntity{

    @NotBlank
    @Column(name = "nombre", length = 20)
    private String nombre;

    @NotBlank
    @Column(name = "apellido", length = 20)
    private String apellido;

    @NotBlank
    @Column(name = "genero", length = 20)
    private String genero;

    @NotNull
    @Column(name = "cedula")
    private Integer cedula;

    @NotNull
    @Column(name = "edad")
    private Byte edad;

    @NotBlank
    @Column(name = "username")
    private String username;

    @Email
    @NotBlank
    @Column(name = "correo", length = 100)
    private String correo;

    @NotBlank
    @Column(name = "password", length = 255)
    private String password;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_instructor_id")
    private Usuario instructor;  

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = false)
    @JoinTable(name = "cliente_rutina",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "rutina_id"))
    private List<Rutina> rutinas = new ArrayList<Rutina>();

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Rol.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "rol_usuario",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;
}

