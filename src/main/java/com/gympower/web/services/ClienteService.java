package com.gympower.web.services;



import com.gympower.web.entities.Cliente;

public interface ClienteService extends BaseService<Cliente, Integer>{
    
    Boolean existsByCorreo(String correo) throws Exception;

    String encontrarPassPorCorreo(String correo) throws Exception;


}
