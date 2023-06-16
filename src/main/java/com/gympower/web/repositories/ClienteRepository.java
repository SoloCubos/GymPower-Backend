package com.gympower.web.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gympower.web.entities.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Integer>{
    
    Boolean existsByCorreo(String correo);

    @Query("SELECT c.password FROM cliente c WHERE c.correo = :correo")
    String findPasswordByCorreo(@Param("correo") String correo);


}
