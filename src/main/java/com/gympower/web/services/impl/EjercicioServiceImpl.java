package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Ejercicio;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.EjercicioRepository;
import com.gympower.web.services.EjercicioService;

@Service
public class EjercicioServiceImpl extends BaseServiceImpl<Ejercicio, Integer> implements EjercicioService{
    
    @Autowired
    private EjercicioRepository ejercicioRepository;

    public EjercicioServiceImpl(BaseRepository<Ejercicio, Integer> baseRepository) {
        super(baseRepository);
    }

    
}
