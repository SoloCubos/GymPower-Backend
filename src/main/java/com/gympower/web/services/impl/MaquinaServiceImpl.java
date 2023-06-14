package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Maquina;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.MaquinaRepository;
import com.gympower.web.services.MaquinaService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MaquinaServiceImpl extends BaseServiceImpl<Maquina, Integer> implements MaquinaService{

    @Autowired
    private MaquinaRepository maquinaRepository;

    public MaquinaServiceImpl(BaseRepository<Maquina, Integer> baseRepository) {
        super(baseRepository);
    }
    
}
