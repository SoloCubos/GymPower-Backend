package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Usuario;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.UsuarioRepository;
import com.gympower.web.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements UsuarioService{
    
    @Autowired
    private UsuarioRepository clienteRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Integer> baseRepository) {
        super(baseRepository);
    }
    /*
    @Override
    public Boolean existsByCorreo(String correo) throws Exception {
        try {
            System.out.println(clienteRepository.existsByCorreo(correo));
            return clienteRepository.existsByCorreo(correo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String encontrarPassPorCorreo(String correo) throws Exception {
        try {
            
            String contraseña = clienteRepository.encontrarPassPorCorreo(correo);
            System.out.println(contraseña);
            return contraseña;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
*/
    

    

}
