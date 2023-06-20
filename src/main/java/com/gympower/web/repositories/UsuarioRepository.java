package com.gympower.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gympower.web.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Integer>{
    
    Optional<Usuario> findByUsername(String username);

    @Query(value = "Select from usuario where username = :username", nativeQuery = true)
    Optional<Usuario> getName(@Param("username") String username);

    /*
    Boolean existsByCorreo(String correo);

    @Query(value = "SELECT password FROM cliente WHERE correo = :correo", nativeQuery = true)
    String encontrarPassPorCorreo(@Param("correo") String correo);
*/
}
