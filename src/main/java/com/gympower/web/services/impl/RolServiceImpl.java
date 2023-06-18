package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Rol;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.RolRepository;
import com.gympower.web.services.RolService;


@Service
public class RolServiceImpl extends BaseServiceImpl<Rol, Integer> implements RolService{
    
    @Autowired
    private RolRepository instructorRepository;

    public RolServiceImpl(BaseRepository<Rol, Integer> baseRepository) {
        super(baseRepository);
    }

}
