package com.gympower.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympower.web.entities.Instructor;
import com.gympower.web.repositories.BaseRepository;
import com.gympower.web.repositories.InstructorRepository;
import com.gympower.web.services.InstructorService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class InstructorServiceImpl extends BaseServiceImpl<Instructor, Integer> implements InstructorService{
    
    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorServiceImpl(BaseRepository<Instructor, Integer> baseRepository) {
        super(baseRepository);
    }

}
