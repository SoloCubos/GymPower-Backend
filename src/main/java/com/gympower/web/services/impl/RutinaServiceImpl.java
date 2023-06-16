package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Rutina;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.RutinaRepository;
import com.gympower.web.services.RutinaService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class RutinaServiceImpl extends BaseServiceImpl<Rutina, Integer> implements RutinaService{

    @Autowired
    private RutinaRepository rutinaRepository;

    public RutinaServiceImpl(BaseRepository<Rutina, Integer> baseRepository) {
        super(baseRepository);
    }
        
}
