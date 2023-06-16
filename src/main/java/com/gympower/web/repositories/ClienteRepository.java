package com.gympower.web.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gympower.web.entities.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Integer>{
    
    Boolean existsByCorreo(String correo);

    @Query(value = "SELECT password FROM cliente WHERE correo = :correo", nativeQuery = true)
    String encontrarPassPorCorreo(@Param("correo") String correo);


}
