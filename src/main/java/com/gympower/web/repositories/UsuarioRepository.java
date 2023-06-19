package com.gympower.web.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gympower.web.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Integer>{
    
    Usuario findByCorreo(String correo);

    /*
    Boolean existsByCorreo(String correo);

    @Query(value = "SELECT password FROM cliente WHERE correo = :correo", nativeQuery = true)
    String encontrarPassPorCorreo(@Param("correo") String correo);
*/
}
